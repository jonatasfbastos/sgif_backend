package br.com.ifba.curso.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.matrizcurricular.model.MatrizCurricular;
import br.com.ifba.modalidade.model.Modalidade;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "curso")
@Data
@EqualsAndHashCode(callSuper = false)

public class Curso extends PersistenceEntity implements Serializable{
    
    private String nome;
    private String codigoCurso;
    private String sigla;
    private String descricao;
    boolean ativo;
    
    //Varios cursos podem estar associados a uma modalidade
    @ManyToOne(fetch = FetchType.EAGER)    
    private Modalidade modalidade;
    
    //Um curso esta associado a uma ou mais matrizes curriculares
    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List <MatrizCurricular> matrizCurricular;
}
