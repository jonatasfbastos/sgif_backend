package br.com.ifba.sgif.api.entity.item.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.ifba.sgif.api.entity.relatoriomensal.model.RelatorioMensal;
import br.com.ifba.sgif.api.entity.requisicao.model.Requisicao;
import br.com.ifba.sgif.api.entity.tipodeitem.model.TipoDeItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.ifba.sgif.api.entity.empenho.model.Empenho;
import br.com.ifba.sgif.api.entity.fornecedor.model.Fornecedor;
import br.com.ifba.sgif.api.infrastructure.model.PersistenceEntity;
import br.com.ifba.sgif.api.entity.usuario.model.Usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Classe que representa um item.
 *
 * @author vitor
 * Editado por Andesson Reis
 * @since V1.0.1
 * 
 * Esta classe representa um item utilizado na organização.
 * 
 * Veja também: {@link Requisicao}
 * Veja também: {@link TipoDeItem}
 * Veja também: {@link Fornecedor}
 */
@Entity(name = "item")
@Table(name = "itens")
@Data
@EqualsAndHashCode(callSuper = false)
public class Item extends PersistenceEntity implements Serializable {
 
    @NotNull
    private String nome;

    @NotNull
    private String unidadeMedida;

    @NotNull
    private int alerta;

    @NotNull
    private int quantidade;

    @NotNull
    private int quantidadeMinima;

    @OneToOne
    @JoinColumn(name = "criador_id")
    private Usuario criador;

    @OneToOne
    @JoinColumn(name = "relatorio_id")
    private RelatorioMensal relatorioMensal;

    @Temporal(TemporalType.DATE)
    private Date validade;

    @Temporal(TemporalType.DATE)
    private Date dataNot;

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

    @ManyToOne
    @JoinColumn(name = "tipoDeItem_id")
    @JsonIgnoreProperties("itens")
    private TipoDeItem tipoDeItem;

    @OneToMany(mappedBy = "itens")
    @JsonIgnoreProperties("itens")
    private List<Requisicao> requisicoes;
}
