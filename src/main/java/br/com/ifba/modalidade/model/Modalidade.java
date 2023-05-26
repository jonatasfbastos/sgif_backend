package br.com.ifba.modalidade.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ifba.curso.model.Curso;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "modalidade")
@Data
@EqualsAndHashCode(callSuper = false)
public class Modalidade extends PersistenceEntity implements Serializable{
    //Atributos
    private String nome;
    private String descricao;

    //Uma modalidade esta associada a um ou varios cursos
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    private List<Curso> cursos;
}
