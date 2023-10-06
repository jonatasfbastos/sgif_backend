/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.entity.setor.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.requisicao.model.Requisicao;
import br.com.ifba.entity.usuario.model.Usuario;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 *
 * @author Everton.
 */
@Entity // Indicando que essa classe é uma das que vão se tornar persistível no banco de
        // dados.

@Table(name = "setor")
@Data
@EqualsAndHashCode(callSuper = false)
public class Setor extends PersistenceEntity {
    // Atributos
    private String nome;
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "setor")
    private List<Requisicao> requisicoes;

    @OneToOne
    private Usuario criador;

}
