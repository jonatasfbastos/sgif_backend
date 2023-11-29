package br.com.ifba.sgif.api.entity.usuario.model;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.ifba.sgif.api.entity.roles.model.Role;
import br.com.ifba.sgif.api.infrastructure.model.PersistenceEntity;
import br.com.ifba.sgif.api.entity.perfilusuario.model.PerfilUsuario;

import lombok.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Esta classe, descendente da classe Pessoa, representa um usuario.
 * Nenhum dos atributos desta classe pode ser nulo.
 *
 * @author vitor
 * Editado por Andesson Reis, Giovane Neves
 * @since Desde V1.0.1
 *
 *  Veja também: {@link PerfilUsuario}
 */

@Entity(name = "usuario")
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Usuario extends PersistenceEntity implements UserDetails, Serializable {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    private static final long SerialVersionUID = 1L;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_usuario_id", referencedColumnName = "id")
    @JsonIgnoreProperties("usuarios")
    private PerfilUsuario perfilUsuario;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_roles",
            uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "role_id"}, name = "unique_usuario_role"),
            joinColumns = @JoinColumn(
                name = "usuario_id",
                referencedColumnName = "id",
                table = "usuarios",
                foreignKey = @ForeignKey(name = "usuario_fk", value = ConstraintMode.CONSTRAINT)
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    referencedColumnName = "id",
                    table = "roles",
                    foreignKey = @ForeignKey(
                            name = "role_fk",
                            value = ConstraintMode.CONSTRAINT
                    )
            )
    )
    private List<Role> roles;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    /**
     * Pega as permissões do usuário.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return lista de permissões do usuário.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // TODO: Adicionar lógica para dar permissão de administrador a determinados usuários.

        return roles;
    }

    /**
     * Pega senha do usuário.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return senha do usuário.
     */
    @Override
    public String getPassword() {
        return senha;
    }

    /**
     * Pega login do usuário.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return login do usuário.
     */
    @Override
    public String getUsername() {
        return login;
    }

    // TODO: Trabalhar com os métodos abaixo para ativação e desativação de contas.

    /**
     * Retorna status da conta (conta que expira ou não).
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return status da conta.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Retorna status da conta do usuário (conta do usuário bloqueável ou não).
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return status da conta do usuário.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Retorna status das credenciais (credenciais que expiram ou não).
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return status das credenciais.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Retorna status do usuário (ativado ou desativado).
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return status do usuário.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "";
    }
}