package br.com.ifba.entity.permissao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import br.com.ifba.entity.perfilusuario.dto.PerfilUsuarioResponseDto;
import br.com.ifba.entity.permissaolink.dto.PermissaoLinkResponseDto;

/**
 * Classe de transferência de dados (DTO) para representar dados de resposta relacionados à entidade "Permissão".
 *
 * @author Andesson Reis
 * Desde V1.0.1
 *
 * DTO para representar dados de resposta da entidade 'Permissão'.
 *
 * @param nome - O nome da permissão.
 * @param grupo - Indica se a permissão é um grupo.
 * @param icone - O ícone associado à permissão.
 * @param perfis - Lista de perfis de usuário associados à permissão.
 * @param links - Lista de links associados à permissão.
 * 
 * Veja também: {@link br.com.ifba.entity.permissao.model.Permissao}
 * Veja também: {@link br.com.ifba.entity.perfilusuario.model.PerfilUsuario}
 * Veja também: {@link br.com.ifba.entity.permissaolink.model.PermissaoLink}
 */
public record PermissaoResponseDto(
        /**
         * O nome da permissão.
         */
        @JsonProperty(value = "nome")
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
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String icone,

        /**
         * Lista de perfis de usuário associados à permissão.
         */
        @JsonProperty(value = "perfis")
        List<PerfilUsuarioResponseDto> perfis,

        /**
         * Lista de links associados à permissão.
         */
        @JsonProperty(value = "links")
        List<PermissaoLinkResponseDto> links
) {
}
