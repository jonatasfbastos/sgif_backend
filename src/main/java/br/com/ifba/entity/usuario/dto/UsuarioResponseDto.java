package br.com.ifba.entity.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ifba.entity.perfilusuario.dto.PerfilUsuarioRequestDto;

/**
 *
 * @author Andesson Reis
 *
 * DTO para resposta às requisições direcionadas à entidade 'usuario'.
 * @param username
 * @param perfilUsuario
 */

 public record UsuarioResponseDto(
    @JsonProperty(value = "username")
    String username,
    @JsonProperty(value = "perfilUsuario")
    PerfilUsuarioRequestDto perfilUsuario
 ){}