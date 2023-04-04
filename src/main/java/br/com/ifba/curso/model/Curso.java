package br.com.ifba.curso.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.matrizcurricularr.model.MatrizCurricular;
import br.com.ifba.modalidade.model.Modalidade;
import lombok.Data;

@Entity
@Table(name = "curso")
@Data
public class Curso extends PersistenceEntity implements Serializable{
    
    private String nome;
    private String codigoCurso;
    private String sigla;
    private String descricao;
    
    //VÃ¡rios cursos podem estar associados a uma modalidade
    @ManyToOne(fetch = FetchType.EAGER)    
    private Modalidade modalidade;
    
    //Um curso estÃ¡ associado a uma ou mais matrizes curriculares
    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List <MatrizCurricular> matrizCurricular;
}
