/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.perfilusuario.model.PerfilUsuario;
import br.com.ifba.pessoa.model.Pessoa;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author vitor
 */

@Entity
@Table(name = "usuario")
@Data
@EqualsAndHashCode(callSuper = false)
public class Usuario extends PersistenceEntity {
    private String login;
    private String senha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "perfil_usuario_id", referencedColumnName = "ID")
    @JsonIgnoreProperties("usuarios")
    private PerfilUsuario perfilUsuario;

    // @OneToOne(fetch = FetchType.LAZY)
    // private Pessoa pessoa;

}
