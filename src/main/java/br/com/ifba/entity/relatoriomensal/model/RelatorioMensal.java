package br.com.ifba.entity.relatoriomensal.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.item.model.Item;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Esta classe representa um relatório mensal.
 *
 * @author unknown
 * Editado por Andesson Reis
 * @since V1.0.1
 */
@Entity
@Table(name = "relatorio_mensal")
@Data
@EqualsAndHashCode(callSuper = false)
public class RelatorioMensal extends PersistenceEntity {
    /**
     * O nome do relatório mensal. Não pode ser nulo.
     */
    private String nome;

    /**
     * A quantidade inicial.
     */
    private int qtdInicial;

    /**
     * A quantidade que entrou.
     */
    private int qtdEntrou;

    /**
     * A quantidade que saiu.
     */
    private int qtdSaiu;

    /**
     * O valor total.
     */
    private float valorTotal;

    /**
     * O valor total das saídas.
     */
    private float valorTotalSairam;

    /**
     * A data do relatório mensal.
     */
    private String data;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
