package br.com.ifba.avaliacao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.ifba.disciplina.model.Disciplina;
import br.com.ifba.formulario.model.Formulario;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "avaliacao")
@Data
@EqualsAndHashCode(callSuper = false)
public class Avaliacao extends PersistenceEntity implements Serializable{
    private String descricao;
    private String dataFim;
    private String datainicio;
    
    @OneToOne   
    private Formulario formulario;    
   
    @OneToOne
    private Disciplina disciplina;
}
