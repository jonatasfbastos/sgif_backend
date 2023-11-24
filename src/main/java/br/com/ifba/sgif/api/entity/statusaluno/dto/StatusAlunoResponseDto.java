package br.com.ifba.sgif.api.entity.statusaluno.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.sgif.api.entity.aluno.dto.AlunoResponseDto;

import java.util.List;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * DTO para representar dados de resposta relacionados à entidade 'StatusAluno'.
 *
 * @param id - O ID do status do aluno.
 * @param nome - O nome do status do aluno.
 * @param descricao - A descrição do status do aluno.
 * @param alunos - A lista de alunos associados a este status.
 */
public record StatusAlunoResponseDto(
        @JsonProperty(value = "id")
        Long id,

        @JsonProperty(value = "nome")
        String nome,

        @JsonProperty(value = "descricao")
        String descricao,

        @JsonProperty(value = "alunos")
        List<AlunoResponseDto> alunos
) {
}
