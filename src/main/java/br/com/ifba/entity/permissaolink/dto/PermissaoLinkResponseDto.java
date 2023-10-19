package br.com.ifba.entity.permissaolink.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.entity.permissao.dto.PermissaoResponseDto;

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
 * Veja também: {@link br.com.ifba.entity.permissaolink.model.PermissaoLink}
 */
public record PermissaoLinkResponseDto(
    @JsonProperty("nome")
    String nome,

    @JsonProperty("url")
    String url,

    @JsonProperty("permissoes")
    List<PermissaoResponseDto> permissoes
) {}
