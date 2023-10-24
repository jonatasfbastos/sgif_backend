package br.com.ifba.entity.matrizcurricular.model;

import br.com.ifba.entity.curso.model.Curso;
import br.com.ifba.entity.etapacurso.model.EtapaCurso;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Esta classe representa uma Matriz Curricular.
 *
 * @author unknown
 * @since V1.0.1
 * @Editado por Andesson Reis
 */
@Entity
@Data
@Table(name = "matriz_curricular")
@EqualsAndHashCode(callSuper = false)
public class MatrizCurricular extends PersistenceEntity implements Serializable {
    
    /**
     * O nome da matriz curricular.
     */
    private String nome;

    /**
     * A descrição da matriz curricular.
     */
    private String descricao;

    /**
     * Uma matriz curricular pode estar associada a várias etapas do curso.
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<EtapaCurso> etapacurso;

    /**
     * Uma ou mais matrizes estão relacionadas a um curso.
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Curso> cursos;
}
