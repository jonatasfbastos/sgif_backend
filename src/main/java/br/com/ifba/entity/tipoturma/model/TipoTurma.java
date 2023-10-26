package br.com.ifba.entity.tipoturma.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.turma.model.Turma;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Esta classe representa um Tipo de Turma.
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
 */
@Entity(name = "tipo_turma")
@Data
@Table(name = "tipo_turma")
@EqualsAndHashCode(callSuper = false)
public class TipoTurma extends PersistenceEntity implements Serializable {
    
    /**
     * O nome do tipo de turma.
     */
    private String nome;

    /**
     * A descrição do tipo de turma.
     */
    private String descricao;

    /**
     * As turmas associadas a este tipo de turma.
     */
    @OneToMany(mappedBy = "tipoTurma", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Turma> turmas;
}
