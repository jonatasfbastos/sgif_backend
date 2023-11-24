package br.com.ifba.sgif.api.entity.modalidade.dto;

import br.com.ifba.sgif.api.entity.curso.dto.CursoRequestDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * DTO para receber dados de requisições direcionadas à entidade 'Modalidade'.
 *
 * @param nome - O nome da modalidade (não pode ser nulo).
 * @param descricao - A descrição da modalidade (não pode ser nula).
 * @param cursos - A lista de cursos associados à modalidade.
 */
public class ModalidadeRequestDto {

    @JsonProperty(value = "nome")
    @NotNull(message = "O nome da modalidade é obrigatório.")
    @NotBlank(message = "O nome da modalidade não pode ser vazio.")
    private String nome;

    @JsonProperty(value = "descricao")
    @NotNull(message = "A descrição da modalidade é obrigatória.")
    @NotBlank(message = "A descrição da modalidade não pode ser vazia.")
    private String descricao;

    @JsonProperty(value = "cursos")
    private List<CursoRequestDto> cursos;
}
