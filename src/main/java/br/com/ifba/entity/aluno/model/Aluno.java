package br.com.ifba.entity.aluno.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.ifba.entity.pessoa.model.Pessoa;
import br.com.ifba.entity.statusaluno.model.StatusAluno;
import br.com.ifba.entity.turma.model.Turma;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Autor Unknwon
 * Editado por Giovane  Neves
 * @Since Desde V1.0.1
 * <p>
 * Esta classe, descendente da classe Pesso, representa um aluno.
 * Nenhum dos atributos desta classe pode ser nulo.
 * <p>
 * Veja também: {@link br.com.ifba.entity.turma.model.Turma}
 */
@Entity(name = "aluno")
@Table(name = "alunos")
@Data
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@PrimaryKeyJoinColumn(name="aluno_id",referencedColumnName = "id")
public class Aluno extends Pessoa implements Serializable{

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    /**
     * A matrícula do aluno, ela possui padronização,
     * é única e não pode ser nula.
     */
    @Column(name = "matricula", nullable = false, unique = true)
    private String matricula;

    /**
     * A turma do aluno.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turma_id", referencedColumnName = "ID")
    private Turma turma;

    /**
     * O status do aluno.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", referencedColumnName = "ID")
    private StatusAluno statusAluno;

}
