
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.empenho.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.item.model.Item;
import br.com.ifba.usuario.model.Usuario;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author rocki.julius
 */

@Entity
@Table(name = "empenho")
@Data
public class Empenho extends PersistenceEntity {

    private String nota;

    @OneToOne
    private Usuario criador;

    @ManyToMany
    private List<Item> itens;

}