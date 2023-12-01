package br.com.ifba.sgif.api.entity.tipoturma.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ifba.sgif.api.entity.turma.dto.TurmaResponseDto;

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
public record TipoTurmaResponseDto (
    @JsonProperty(value = "id")
    Long id,

    @JsonProperty(value = "nome")
    String nome,

    @JsonProperty(value = "descricao")
    String descricao,

    @JsonProperty(value = "turmas")
    List<TurmaResponseDto> turmas
){
  
}
