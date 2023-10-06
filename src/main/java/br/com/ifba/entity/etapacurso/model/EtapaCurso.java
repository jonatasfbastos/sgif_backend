package br.com.ifba.entity.etapacurso.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ifba.entity.disciplina.model.Disciplina;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.matrizcurricular.model.MatrizCurricular;
import br.com.ifba.entity.turma.model.Turma;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "etapa_curso")
@Data
@EqualsAndHashCode(callSuper = false)
public class EtapaCurso extends PersistenceEntity implements Serializable{
    private String nome;
    private int periodo;
    private int cargaHoraria;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    private MatrizCurricular matrizCurricular; 
    
    @OneToMany(fetch = FetchType.LAZY)
    private List<Disciplina> disciplinas; 
    
    @OneToMany(fetch = FetchType.LAZY)
    private List <Turma> turma; 

}
