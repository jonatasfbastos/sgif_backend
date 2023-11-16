package br.com.ifba.entity.roles.model;

import br.com.ifba.entity.usuario.model.Usuario;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Entity(name = "role")
@Table(name = "roles")
public class Role extends PersistenceEntity implements GrantedAuthority {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    /**
     * O nome do papel. Exemplo: "ROLE_ALUNO"
     */
    private String nomePapel;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    /**
     * Pega o nome do papel.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return o nome do papel.
     */
    public String getNomePapel() {
        return nomePapel;
    }

    /**
     * Seta o nome do papel.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param nomePapel O nome do papel a ser atribuido.
     */
    public void setNomePapel(String nomePapel) {
        this.nomePapel = nomePapel;
    }

    /**
     * Retorna o nome do papel do usuário.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return o papel do usuário.
     */
    @Override
    public String getAuthority() {
        return this.nomePapel;
    }

}
