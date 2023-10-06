package br.com.ifba.entity.formulario.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.ifba.entity.avaliacao.model.Avaliacao;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "formulario")
@Data
@EqualsAndHashCode(callSuper = false)

public class Formulario extends PersistenceEntity implements Serializable{
    
    private String titulo;
    private String descricao;
    
    @OneToOne
    private Avaliacao avaliacao;
}
