package br.com.ifba.sgif.api.entity.permissao.dto;

import br.com.ifba.sgif.api.entity.perfilusuario.dto.PerfilUsuarioResponseDto;
import br.com.ifba.sgif.api.entity.perfilusuario.model.PerfilUsuario;
import br.com.ifba.sgif.api.entity.permissao.model.Permissao;
import br.com.ifba.sgif.api.entity.permissaolink.dto.PermissaoLinkResponseDto;
import br.com.ifba.sgif.api.entity.permissaolink.model.PermissaoLink;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

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
 * Veja também: {@link Permissao}
 * Veja também: {@link PerfilUsuario}
 * Veja também: {@link PermissaoLink}
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
