package br.com.ifba.entity.modalidade.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ifba.entity.curso.model.Curso;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "modalidade")
@Data
@EqualsAndHashCode(callSuper = false)
public class Modalidade extends PersistenceEntity implements Serializable{

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //
    private String nome;
    private String descricao;

    //Uma modalidade esta associada a um ou varios cursos
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    private List<Curso> cursos;
}
