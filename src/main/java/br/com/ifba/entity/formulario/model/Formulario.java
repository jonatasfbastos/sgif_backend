package br.com.ifba.entity.formulario.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ifba.entity.formulario.dto.FormularioRequestDto;
import br.com.ifba.entity.formulario.dto.FormularioResponseDto;
import br.com.ifba.entity.questao.model.Questao;
import br.com.ifba.infrastructure.model.PersistenceEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Esta classe representa um formulário que contém um título,
 * uma descrição e uma lista de questões associadas.
 *
 * Veja também: {@link br.com.ifba.entity.questao.model.Questao}
 * Veja também: {@link br.com.ifba.entity.formulario.dto.FormularioRequestDto}
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

    /**
     *
     * @author Giovane Neves
     *
     * Fábrica de objeto Formulario.
     *
     * @param formDto - O objeto de transferência com dados do formulário;
     * @return um objeto Formulário.
     */
    public static Formulario fromRequestDto(FormularioRequestDto formDto){

        return new Formulario(
                formDto.titulo(),
                formDto.descricao(),
                formDto.questoes().stream()
                        .map(Questao::fromRequestDto)
                        .collect(Collectors.toList())
        );

    }

    /**
     * @author Giovane Neves
     *
     * Cria um objeto de resposta DTO para ser enviado no ResponseBody
     * das requisições direcionada à entidade 'Formulário'.
     *
     * @return um objeto FormularioResponseDto com dados do formulário.
     */
    public FormularioResponseDto toResponseDto(){

        return new FormularioResponseDto(this.titulo, this.descricao);

    }

}
