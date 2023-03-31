/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.requisicao.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.item.model.Item;
import br.com.ifba.setor.model.Setor;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Vitor
 */
@Entity
@Table(name = "requisicao")
@Data
@EqualsAndHashCode(callSuper = false)
public class Requisicao extends PersistenceEntity {
    private String codigoSaida;
    private boolean status;
    private int quantidadeItensReq;

    @JsonIgnoreProperties("requisicoes")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "setor_id")
    private Setor setor;

    // @JsonBackReference
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "pessoa_id")
    // private Pessoa requisitante;

    private String requisitante;

    @JsonIgnoreProperties("requisicoes")
    // @ManyToMany(fetch = FetchType.EAGER)
    // @JoinColumn(name = "item_id")
    @OneToOne
    private Item itens;
}
