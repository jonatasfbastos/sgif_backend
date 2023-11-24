package br.com.ifba.sgif.api.entity.curso.dto;

import br.com.ifba.sgif.api.entity.matrizcurricular.dto.MatrizCurricularResponseDto;
import br.com.ifba.sgif.api.entity.modalidade.dto.ModalidadeResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Giovane Neves
 * Desde V1.0.1
 *
 * DTO para respostas de requisições direcionadas
 * à entidade 'Curso'.
 *
 * @param nome O nome do curso.
 * @param codigo_curso O código do curso.
 * @param sigla A sigla do curso.
 * @param descricao A descrição do curso.
 * @param ativo O status do curso (ativo, true, ou desativado, false).
 * @param modalidade A modalidade do curso.
 * @param matrizesCurriculares As matrizes curriculares do curso, pode ter uma ou várias.
 *
 * Veja também: {@link ModalidadeResponseDto}
 * Veja também: {@link MatrizCurricularResponseDto}
 */
public record CursoResponseDto(
        @JsonProperty(value = "nome")
        String nome,
        @JsonProperty(value = "codigo_curso")
        String codigo_curso,
        @JsonProperty(value = "sigla")
        String sigla,
        @JsonProperty(value = "descricao")
        String descricao,
        @JsonProperty(value = "ativo")
        boolean ativo,
        @JsonProperty(value = "modalidade")
        ModalidadeResponseDto modalidade,
        @JsonProperty(value = "matrizes_curriculares")
        List<MatrizCurricularResponseDto> matrizesCurriculares
) {
}
