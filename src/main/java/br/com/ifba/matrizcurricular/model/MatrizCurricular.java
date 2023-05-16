package br.com.ifba.matrizcurricular.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ifba.curso.model.Curso;
import br.com.ifba.etapacurso.model.EtapaCurso;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "matriz_curricular")
@Data
@EqualsAndHashCode(callSuper = false)
public class MatrizCurricular extends PersistenceEntity implements Serializable{
    //atributos
    private String nome;
    private String descricao;
    
    //Uma matriz curricular pode estar associada a uma ou mais etapas do curso
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EtapaCurso> etapacurso;
    
    //Uma ou mais matrizes estÃ£o relacionadas a um curso
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Curso curso;
}
