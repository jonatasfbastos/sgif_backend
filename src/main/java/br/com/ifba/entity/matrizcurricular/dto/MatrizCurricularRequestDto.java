package br.com.ifba.entity.matrizcurricular.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ifba.entity.curso.dto.CursoResponseDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * DTO para receber dados de requisições direcionadas à entidade 'MatrizCurricular'.
 *
 * @param nome - O nome da matriz curricular (não pode ser nulo).
 * @param descricao - A descrição da matriz curricular (não pode ser nula).
 * @param etapacurso - A lista de etapas do curso associadas à matriz curricular.
 * @param cursos - A lista de cursos associados à matriz curricular.
 */
public class MatrizCurricularRequestDto {

    @JsonProperty(value = "nome")
    @NotNull(message = "O nome da matriz curricular é obrigatório.")
    @NotBlank(message = "O nome da matriz curricular não pode ser vazio.")
    private String nome;

    @JsonProperty(value = "descricao")
    @NotNull(message = "A descrição da matriz curricular é obrigatória.")
    @NotBlank(message = "A descrição da matriz curricular não pode ser vazia.")
    private String descricao;

    @JsonProperty(value = "etapacurso")
    private List<EtapaCursoResponseDto> etapacurso;

    @JsonProperty(value = "cursos")
    private List<CursoResponseDto> cursos;
}
