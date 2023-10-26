package br.com.ifba.entity.statusaluno.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ifba.entity.aluno.dto.AlunoRequestDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * DTO para receber dados de requisições relacionadas à entidade 'StatusAluno'.
 *
 * @param nome - O nome do status do aluno, não pode ser nulo ou vazio.
 * @param descricao - A descrição do status do aluno.
 * @param alunos - A lista de alunos associados a este status.
 */
public record StatusAlunoRequestDto(
        @JsonProperty(value = "nome")
        @NotNull(message = "O nome do status do aluno é obrigatório.")
        @NotBlank(message = "O nome do status do aluno não pode ser vazio.")
        @Size(min = 1, message = "O nome do status do aluno não pode ser vazio.")
        String nome,

        @JsonProperty(value = "descricao")
        String descricao,

        @JsonProperty(value = "alunos")
        List<AlunoRequestDto> alunos
) {
}
