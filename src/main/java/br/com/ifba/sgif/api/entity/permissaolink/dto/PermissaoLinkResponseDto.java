package br.com.ifba.sgif.api.entity.permissaolink.dto;

import br.com.ifba.sgif.api.entity.permissaolink.model.PermissaoLink;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.sgif.api.entity.permissao.dto.PermissaoResponseDto;

import java.util.List;

/**
 * Classe de transferência de dados (DTO) para enviar dados de resposta relacionados à entidade "PermissaoLink".
 *
 * @author Andesson Reis
 * @since V1.0.1
 *
 * DTO para enviar dados de resposta relacionados à entidade 'PermissaoLink'.
 *
 * @param nome - O nome do link de permissão.
 * @param url - A URL associada ao link de permissão.
 * @param permissoes - Lista de permissões associadas ao link.
 *
 * Veja também: {@link PermissaoLink}
 */
public record PermissaoLinkResponseDto(
    @JsonProperty("nome")
    String nome,

    @JsonProperty("url")
    String url,

    @JsonProperty("permissoes")
    List<PermissaoResponseDto> permissoes
) {}
