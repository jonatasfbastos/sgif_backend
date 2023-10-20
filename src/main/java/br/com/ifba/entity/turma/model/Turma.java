package br.com.ifba.entity.turma.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.ifba.entity.etapacurso.model.EtapaCurso;
import br.com.ifba.entity.tipoturma.model.TipoTurma;
import br.com.ifba.infrastructure.model.PersistenceEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Unknown
 * Editado por Giovane Neves
 * @since Desde V1.0.1
 */
@Entity(name = "turma")
@Table(name = "turmas")
@Data
@EqualsAndHashCode(callSuper = false)
public class Turma extends PersistenceEntity implements Serializable {

    // =========================================================== //
    // =============== [       ATRIBUTOS        ] ================ //
    // =========================================================== //

    /**
     * O nome da turma, não pode ser nulo.
     */
    @Column(name = "nome", nullable = false)
    private String nome;

    /**
     * O código da turma, não pode ser nulo e deve ser único.
     */
    @Column(name = "codigo_turma", nullable = false, unique = true)
    private String codigoTurma;

    /**
     * A sigla da turma.
     */
    @Column(name = "sigla")
    private String sigla;

    /**
     * O status da turma, 'true', caso esteja ativada e 'false' caso contrário.
     */
    @Column(name = "ativa")
    private boolean ativa;

    /**
     * O tipo de turma.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turma_id", referencedColumnName = "ID")
    private TipoTurma tipoTurma;

    /**
     * A etapa do curso ao qual a turma pertence.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private EtapaCurso etapaCurso;

}
