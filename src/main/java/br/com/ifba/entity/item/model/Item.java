package br.com.ifba.entity.item.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.ifba.entity.empenho.model.Empenho;
import br.com.ifba.entity.fornecedor.model.Fornecedor;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.relatoriomensal.model.RelatorioMensal;
import br.com.ifba.entity.requisicao.model.Requisicao;
import br.com.ifba.entity.tipodeitem.model.TipoDeItem;
import br.com.ifba.entity.usuario.model.Usuario;

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
 * Veja também: {@link br.com.ifba.entity.requisicao.model.Requisicao}
 * Veja também: {@link br.com.ifba.entity.tipodeitem.model.TipoDeItem}
 * Veja também: {@link br.com.ifba.entity.fornecedor.model.Fornecedor}
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

    @ManyToOne
    @JsonIgnoreProperties("itens")
    private Empenho empenhos;

    @OneToMany(mappedBy = "itens")
    @JsonIgnoreProperties("itens")
    private List<Requisicao> requisicoes;
}
