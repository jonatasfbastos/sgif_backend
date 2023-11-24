package br.com.ifba.sgif.api.entity.statusaluno.model;

import br.com.ifba.sgif.api.entity.aluno.model.Aluno;
import br.com.ifba.sgif.api.infrastructure.model.PersistenceEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Esta classe representa o status de um aluno.
 *
 * @author Ellen Cristina
 * @since V1.0.1
 * Editado por Andesson Reis
 */
@Entity(name = "status_aluno")
@Data
@Table(name = "status_aluno")
@EqualsAndHashCode(callSuper = false)
public class StatusAluno extends PersistenceEntity implements Serializable {

    /**
     * O nome do status do aluno.
     */
    private String nome;

    /**
     * A descrição do status do aluno.
     */
    private String descricao;

    @JsonIgnore
    @OneToMany(mappedBy = "statusAluno")
    private List<Aluno> alunos;
}
