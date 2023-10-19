package br.com.ifba.entity.permissao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import java.util.List;

import br.com.ifba.entity.perfilusuario.dto.PerfilUsuarioRequestDto;

/**
 * Classe de transferência de dados (DTO) para receber dados de requisições relacionadas à entidade "Permissão".
 *
 * @author Andesson Reis
 * Desde V1.0.1
 *
 * DTO para receber dados de requisições direcionadas à entidade 'Permissão'.
 *
 * @param nome - O nome da permissão.
 * @param grupo - Indica se a permissão é um grupo.
 * @param icone - O ícone associado à permissão.
 * @param perfis - Lista de perfis de usuário associados à permissão.
 * @param links - Lista de links associados à permissão.
 * 
 * Veja também: {@link br.com.ifba.entity.permissao.model.Permissao}
 */
public record PermissaoRequestDto(
        @JsonProperty(value = "nome")
        @NotNull(message = "O nome da permissão é obrigatório.")
        @NotBlank(message = "O nome da permissão não pode ser vazio.")
        @Size(min = 3, max = 150, message = "O nome da permissão deve ter pelo menos 3 caracteres e no máximo 150.")
        String nome,

        /**
         * Indica se a permissão é um grupo.
         */
        @JsonProperty(value = "grupo")
        boolean grupo,

        /**
         * O ícone associado à permissão.
         */
        @JsonProperty(value = "icone")
        String icone,

        /**
         * Lista de perfis de usuário associados à permissão.
         */
        @JsonProperty(value = "perfis")
        List<PerfilUsuarioRequestDto> perfis

        /**
         * Lista de links associados à permissão.
         */
     //   @JsonProperty(value = "links")
       // List<PermissaoLinkRequestDto> links

) {
}
