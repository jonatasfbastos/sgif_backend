package br.com.ifba.entity.questao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.resposta.model.Resposta;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "questao")
@Data
@EqualsAndHashCode(callSuper = false)

public class Questao extends PersistenceEntity implements Serializable{
    
    private String enunciado;
    private boolean required;
    // Uma questão possui uma resposta associada
    @OneToOne(fetch = FetchType.EAGER)  
    private Resposta resposta;
    
}
