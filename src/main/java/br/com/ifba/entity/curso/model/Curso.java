package br.com.ifba.entity.curso.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.matrizcurricular.model.MatrizCurricular;
import br.com.ifba.entity.modalidade.model.Modalidade;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Unknown
 * Editado por Giovane Neves
 * Desde V1.0.1
 *
 * Classe que representa um curso da instituição.
 * Veja também: {@link br.com.ifba.entity.modalidade.model.Modalidade}
 * Veja também: {@link br.com.ifba.entity.matrizcurricular.model.MatrizCurricular}
 */
@Entity(name = "curso")
@Table(name = "cursos")
@Data
@EqualsAndHashCode(callSuper = false)
public class Curso extends PersistenceEntity implements Serializable{

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    /**
     * O nome do curso, não pode ser nulo.
     */
    @Column(name = "nome", nullable = false)
    private String nome;

    /**
     * O código do curso, deve ser único e não
     * pode ser nulo.
     */
    @Column(name = "codigo_curso", nullable = false, unique = true)
    private String codigoCurso;

    /**
     * A sigla do curso.
     * Exemplos: 'ADS', 'MI', 'INFO'.
     */
    @Column(name = "sigla")
    private String sigla;

    /**
     * A descrição do curso.
     */
    @Column(name = "descricao")
    private String descricao;

    /**
     * O status do curso, é 'false' por padrão.
     */
    @Column(name = "ativo")
    boolean ativo;

    /**
     * A modalidade do curso, cada curso só pode estar associado a uma modalidade.
     */
    @ManyToOne(fetch = FetchType.EAGER)    
    private Modalidade modalidade;

    /**
     * A matriz curricular do curso.
     * Um curso pode estar associado a uma ou mais matrizes curriculares.
     */
    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List <MatrizCurricular> matrizesCurriculares;

}
