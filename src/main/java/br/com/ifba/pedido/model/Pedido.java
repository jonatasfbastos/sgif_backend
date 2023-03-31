/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.pedido.model;

import br.com.ifba.empenho.model.Empenho;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.item.model.Item;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.List;
import lombok.Data;

/**
 *
 * @author rocki.julius
 */

@Entity
@Table(name = "pedido")
@Data
public class Pedido extends PersistenceEntity {    
    private String notaFiscal;
    private double valorTotal;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empenho_id", referencedColumnName = "ID")
    private Empenho empenho;
    
    @ManyToMany
    private List<Item> itens;

}