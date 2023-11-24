package br.com.ifba.sgif.api.entity.perfilusuario.dto;

import br.com.ifba.sgif.api.entity.perfilusuario.model.PerfilUsuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * DTO para receber requisições relacionadas à entidade 'Perfil de Usuário'.
 * Este DTO é usado para criar ou atualizar informações de perfil de usuário, incluindo o nome e a descrição.
 *
 * @param nome - O nome do perfil de usuário.
 * @param descricao - A descrição do perfil de usuário.
 *
 * Veja também: {@link PerfilUsuario}
 *
 * @author Andesson Reis
 */
public record PerfilUsuarioRequestDto(
    /**
     * O nome do perfil de usuário.
     */
    @JsonProperty(value = "nome")
    @NotBlank(message = "O nome do perfil não pode ser vazio.")
    @Size(min = 3, max = 150, message = "O nome do perfil precisa ter pelo menos 3 caracteres e 150 no máximo.")
    String nome,
    /**
     * A descrição do perfil de usuário.
     */
    @JsonProperty(value = "descricao")
    @NotBlank(message = "A descrição do perfil não pode ser vazia.")
    @Size(max = 500, message = "A descrição do perfil não pode ter mais de 500 caracteres.")
    String descricao
) {}
