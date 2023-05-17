package br.com.ifba.relatoriomensal.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.item.model.Item;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "rna")
@Data
@EqualsAndHashCode(callSuper = false)
public class RelatorioMensal extends PersistenceEntity {
    String nome;
    int qtdInicial;
    int qtdEntrou;
    int qtdSaiu;
    float valorTotal;
    float valorTotalSairam;
    String data;
    
    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
