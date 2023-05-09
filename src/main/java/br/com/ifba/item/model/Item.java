/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.item.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.ifba.empenho.model.Empenho;
import br.com.ifba.fornecedor.model.Fornecedor;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.pedido.model.Pedido;
import br.com.ifba.requisicao.model.Requisicao;
import br.com.ifba.tipodeitem.model.TipoDeItem;
import br.com.ifba.usuario.model.Usuario;

import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author vitor
 */

@Entity
@Table(name = "item")
@Data
@EqualsAndHashCode(callSuper = false)
public class Item extends PersistenceEntity {
    private String nome;
    private String unidadeMedida;
    private int alerta;
    private int quantidade;
    private int quantidadeMinima;

    @OneToOne
    private Usuario criador;

    @Temporal(TemporalType.DATE)
    private Date validade;
    
    private double valorItem;
    private String perecivel;

    @ManyToOne
    @JoinColumn(name = "empenho_id")
    @JsonIgnoreProperties("itens")
    private Empenho codigoItem;


    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    @JsonIgnoreProperties("itens")
    private Fornecedor fornecedor;

    // @ManyToOne
    // @JoinColumn(name = "codigo_empenho_id")
    // @JsonIgnoreProperties("itens")
    // private Empenho codigoEmpenho;

    @ManyToOne
    @JoinColumn(name = "tipoDeItem_id")
    @JsonIgnoreProperties("itens")
    private TipoDeItem tipoDeItem;

    @ManyToMany(mappedBy = "itens")
    @JsonIgnoreProperties("itens")
    private List<Empenho> empenhos;

    @ManyToMany(mappedBy = "itens")
    @JsonIgnoreProperties("itens")
    private List<Requisicao> requisicoes;

    @ManyToMany(mappedBy = "itens")
    @JsonIgnoreProperties("itens")
    private List<Pedido> pedidos;

}