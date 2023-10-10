package br.com.ifba.entity.formulario.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ifba.entity.questao.model.Questao;
import br.com.ifba.infrastructure.model.PersistenceEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Esta classe representa um formulário que contém um título,
 * uma descrição e uma lista de questões associadas.
 *
 * veja também: {@link br.com.ifba.entity.questao.model.Questao}
 */
@Entity(name = "formulario")
@Table(name = "formularios")
@Data
@EqualsAndHashCode(callSuper = false)
public class Formulario extends PersistenceEntity implements Serializable{

    /**
     * O título do formuláro, não aceita valores nulos.
     */
    @Column(name = "titulo")
    private String titulo;

    /**
     * A descrição do formulário, não aceita valores nulos.
     */
    @Column(name = "descricao")
    private String descricao;

    /**
     * A lista de questões do formulário, todas as questões são obirgatórias.
     * Uma questão é composta por um enunciado e uma resposta.
     */
    @OneToMany
    @JoinColumn(name = "questao_id")
    private List<Questao> questoes;
}
