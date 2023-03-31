package br.com.ifba.resposta.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.questao.model.Questao;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "resposta")
@Data
@EqualsAndHashCode(callSuper = false)
public class Resposta extends PersistenceEntity implements Serializable{
    //Cada resposta possui uma questão associada
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "questao_id", referencedColumnName = "ID")
    private Questao questao;
}
