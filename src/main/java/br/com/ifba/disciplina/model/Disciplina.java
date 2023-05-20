package br.com.ifba.disciplina.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.ifba.avaliacao.model.Avaliacao;
import br.com.ifba.etapacurso.model.EtapaCurso;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.professor.model.Professor;
import ch.qos.logback.core.read.ListAppender;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "disciplina")
@Data
@EqualsAndHashCode(callSuper = false)
public class Disciplina extends PersistenceEntity implements Serializable{
    private String nome;
    private String descricao;
    private String codigo;
    private int cargaHoraria;
    
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Professor> professor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private EtapaCurso etapaCurso;
    
    @OneToOne
    private Avaliacao avaliacao;  
}
