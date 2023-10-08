package br.com.ifba.entity.usuario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.perfilusuario.model.PerfilUsuario;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Esta classe, descendente da classe Pessoa, representa um usuario.
 * Nenhum dos atributos desta classes pode ser nulo.
 */

@Entity
@Table(name = "usuario")
@Data
@EqualsAndHashCode(callSuper = false)
public class Usuario extends PersistenceEntity {

    /**
     * O nome de usuário do usuário. Não pode ser nulo.
     */

    @Column(nullable = false, unique = true)
    private String login;
    
    /**
     * A senha do usuário. Não pode ser nula.
     */

    @NotNull
    private String password;

    /**
     * Perfil do usuario.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "perfil_usuario_id", referencedColumnName = "ID")
    @JsonIgnoreProperties("usuarios")
    private PerfilUsuario perfilUsuario;

}