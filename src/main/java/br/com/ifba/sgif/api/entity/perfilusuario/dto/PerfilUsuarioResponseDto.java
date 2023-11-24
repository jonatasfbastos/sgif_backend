package br.com.ifba.sgif.api.entity.perfilusuario.dto;

import br.com.ifba.sgif.api.entity.perfilusuario.model.PerfilUsuario;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para resposta às requisições direcionadas à entidade 'Perfil de Usuário'.
 * Este DTO representa informações públicas do perfil de usuário, incluindo o nome e a descrição.
 *
 * @param nome - O nome do perfil de usuário.
 * @param descricao - A descrição do perfil de usuário.
 * 
 * Veja também: {@link PerfilUsuario}
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
