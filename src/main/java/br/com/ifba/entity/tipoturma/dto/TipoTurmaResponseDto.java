package br.com.ifba.entity.tipoturma.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ifba.entity.turma.dto.TurmaResponseDto;

import java.util.List;

/**
 * DTO para representar os dados de um Tipo de Turma em respostas.
 *
 * @param nome - O nome do Tipo de Turma.
 * @param descricao - A descrição do Tipo de Turma.
 * @param turmas - A lista de TurmaResponseDto associadas a este Tipo de Turma.
 * 
 * @author Andesson Reis
 * @since V1.0.1
 */
public class TipoTurmaResponseDto {

    @JsonProperty(value = "nome")
    private String nome;

    @JsonProperty(value = "descricao")
    private String descricao;

    @JsonProperty(value = "turmas")
    private List<TurmaResponseDto> turmas;
}
