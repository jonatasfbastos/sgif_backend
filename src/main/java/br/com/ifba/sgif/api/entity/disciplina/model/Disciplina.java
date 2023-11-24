package br.com.ifba.sgif.api.entity.disciplina.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.ifba.sgif.api.entity.avaliacao.model.Avaliacao;
import br.com.ifba.sgif.api.entity.etapacurso.model.EtapaCurso;
import br.com.ifba.sgif.api.infrastructure.model.PersistenceEntity;
import br.com.ifba.sgif.api.entity.professor.model.Professor;
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
