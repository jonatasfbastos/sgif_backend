package br.com.ifba.entity.usuario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.ifba.entity.usuario.dto.UsuarioSimpleResponseDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.perfilusuario.model.PerfilUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * Esta classe, descendente da classe Pessoa, representa um usuario.
 * Nenhum dos atributos desta classes pode ser nulo.
 * 
 *  Veja também: {@link br.com.ifba.entity.perfilusuario}
 */

@Entity(name = "usuario")
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Usuario extends PersistenceEntity {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    /**
     * O nome de usuário do usuário. Não pode ser nulo.
     */

    @Column(nullable = false, unique = true)
    private String login;

    /**
     * A senha do usuário. Não pode ser nula.
     */

    @NotNull
    private String senha;

    /**
     * Perfil do usuario.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "perfil_usuario_id", referencedColumnName = "ID")
    @JsonIgnoreProperties("usuarios")
    private PerfilUsuario perfilUsuario;


    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     *
     * Cria um objeto de resposta DTO simples para ser enviado no ResponseBody
     * das requisições direcionada à entidade 'Usuario'.
     *
     * @return um objeto UsuarioSimpleResponseDto com dados do formulário.
     */
    public UsuarioSimpleResponseDto toSimpleResponseDto(){

         return new UsuarioSimpleResponseDto(this.login);

    }
    

}