package br.com.ifba.entity.permissaolink.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe de transferência de dados (DTO) para receber dados de requisições relacionadas à entidade "PermissãoLink".
 *
 * @author Andesson Reis
 * @since V1.0.1
 *
 * DTO para receber dados de requisições direcionadas à entidade 'PermissãoLink'.
 *
 * @param nome - O nome do link de permissão.
 * @param url - A URL associada ao link de permissão.
 * @param permissaoIds - Lista de IDs de permissões associadas ao link.
 *
 * Veja também: {@link br.com.ifba.entity.permissao.model.Permissao}
 */
public record PermissaoLinkRequestDto(
    /**
     * O nome do link de permissão.
     */
    @JsonProperty(value = "nome")
    @NotNull(message = "O nome do link de permissão é obrigatório.")
    @NotBlank(message = "O nome do link de permissão não pode ser vazio.")
    String nome,

    /**
     * A URL associada ao link de permissão.
     */
    @JsonProperty(value = "url")
    @NotNull(message = "A URL associada ao link de permissão é obrigatória.")
    @NotBlank(message = "A URL associada ao link de permissão não pode ser vazia.")
    String url
) {}
