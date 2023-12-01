package br.com.ifba.sgif.api.entity.perfilusuario.dto;

import br.com.ifba.sgif.api.entity.perfilusuario.model.PerfilUsuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para resposta às requisições direcionadas à entidade 'Perfil de Usuário'.
 * Este DTO representa informações públicas do perfil de usuário, incluindo o nome e a descrição.
 * @author Andesson Reis, Giovane Neves
 * Veja também: {@link PerfilUsuario}
 */

public class PerfilUsuarioResponseDto{
    @JsonProperty(value = "id")
    Long id;

    /**
     * O nome do perfil de usuário.
     */
    @JsonProperty(value = "nome")
    String nome;
    /**
     * A descrição do perfil de usuário.
     */
    @JsonProperty(value = "descricao")
    String descricao;
}
