package br.com.ifba.aluno.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.ifba.pessoa.model.Pessoa;
import br.com.ifba.turma.model.Turma;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "aluno")
@Data
@EqualsAndHashCode(callSuper = false)

public class Aluno extends Pessoa implements Serializable{
    private String matricula;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turma_id", referencedColumnName = "ID")
    private Turma turma;
}
