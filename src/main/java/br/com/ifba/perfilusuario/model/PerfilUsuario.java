/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.perfilusuario.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import br.com.ifba.permissao.model.Permissao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 *
 * @author Igor Lopes
 *         editted by tarciiz
 */
@Entity
@Table(name = "perfilusuario")
@Data
@EqualsAndHashCode(callSuper = false)
public class PerfilUsuario extends PersistenceEntity {

    private String nome;
    private String descricao;

    // @OneToMany(mappedBy = "perfilUsuario", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    // private List<Usuario> usuarios;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Permissao> permissoes;

}