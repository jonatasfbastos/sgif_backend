package br.com.ifba.entity.perfilusuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para resposta às requisições direcionadas à entidade 'Perfil de Usuário'.
 * Este DTO representa informações públicas do perfil de usuário, incluindo o nome e a descrição.
 *
 * @param nome - O nome do perfil de usuário.
 * @param descricao - A descrição do perfil de usuário.
 * 
 * Veja também: {@link br.com.ifba.entity.perfilusuario.model.PerfilUsuario} 
 * 
 * @author Andesson Reis
 */

public record PerfilUsuarioResponseDto(
      /**
       * O nome do perfil de usuário.
       */
      @JsonProperty(value = "nome") 
      String nome,
      /**
       * A descrição do perfil de usuário.
       */
      @JsonProperty(value = "descricao")
      String descricao
    )
{}
