package br.com.ifba.sgif.api.entity.formulario.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ifba.sgif.api.entity.questao.model.Questao;
import br.com.ifba.sgif.api.infrastructure.model.PersistenceEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Esta classe representa um formulário que contém um título,
 * uma descrição e uma lista de questões associadas.
 *
 * Veja também: {@link Questao}
 *
 */
@Entity(name = "formulario")
@Table(name = "formularios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Formulario extends PersistenceEntity implements Serializable{

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    /**
     * O título do formuláro, não aceita valores nulos.
     */
    @Column(name = "titulo", nullable = false)
    private String titulo;

    /**
     * A descrição do formulário, não aceita valores nulos.
     */
    @Column(name = "descricao", nullable = false)
    private String descricao;

    /**
     * A lista de questões do formulário, todas as questões são obirgatórias.
     * Uma questão é composta por um enunciado e uma resposta.
     */
    @OneToMany
    @JoinColumn(name = "questao_id")
    private List<Questao> questoes;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

}
