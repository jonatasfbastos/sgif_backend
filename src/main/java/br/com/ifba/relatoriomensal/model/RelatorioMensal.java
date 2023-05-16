package br.com.ifba.relatoriomensal.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.ifba.infrastructure.model.PersistenceEntity;
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
}
