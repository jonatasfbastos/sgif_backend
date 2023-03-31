package br.com.ifba.etapaCurso.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ifba.disciplina.model.Disciplina;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.matrizCurricular.model.MatrizCurricular;
import br.com.ifba.turma.model.Turma;
import lombok.Data;

@Entity
@Table(name = "etapa_curso")
@Data
public class EtapaCurso extends PersistenceEntity implements Serializable{
    private String nome;
    private int periodo;
    private boolean concluinte;
    private int cargaHoraria;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private MatrizCurricular matrizCurricular; 
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Disciplina disciplina; 
    
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List <Turma> turma; 
}
