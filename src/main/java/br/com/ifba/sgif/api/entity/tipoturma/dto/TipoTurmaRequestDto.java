package br.com.ifba.sgif.api.entity.tipoturma.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ifba.sgif.api.entity.turma.dto.TurmaRequestDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * DTO para receber dados de requisições direcionadas à entidade 'TipoTurma'.
 *
 * @param nome - O nome do tipo de turma (não pode ser nulo).
 * @param descricao - A descrição do tipo de turma.
 * @param turmas - A lista de TurmaRequestDto associadas a este tipo de turma.
 * 
 * @author Andesson Reis
 * @since V1.0.1
 */
public class TipoTurmaRequestDto {

    @JsonProperty(value = "nome")
    @NotNull(message = "O nome do tipo de turma é obrigatório.")
    @NotBlank(message = "O nome do tipo de turma não pode ser vazio.")
    private String nome;

    @JsonProperty(value = "descricao")
    private String descricao;

    @JsonProperty(value = "turmas")
    private List<TurmaRequestDto> turmas;
}
