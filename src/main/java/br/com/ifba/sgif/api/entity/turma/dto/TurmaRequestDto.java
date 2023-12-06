package br.com.ifba.sgif.api.entity.turma.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Objeto DTO que recebe dados de requisições direcionadas à entidade 'Turma'.
 *
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TurmaRequestDto {

    @JsonProperty(value = "nome")
    @NotNull(message = "O nome da turma não pode ser nulo.")
    @NotBlank(message = "O nome da turma não pode ser vazio.")
    @Size(min = 3, max = 70, message = "O nome da turma precisa ter entre 3 e 70 caracteres.")
    private String nome;

    @JsonProperty(value = "codigo_turma")
    @NotNull(message = "O código da turma não pode ser nulo.")
    @NotBlank(message = "O código da turma não pode ser vazio.")
    private String codigoTurma;

    @JsonProperty(value = "sigla")
    @NotNull(message = "A sigla não pode ser nula")
    @NotBlank(message = "A sigla não pode ser vazia.")
    private String sigla;

    @JsonProperty(value = "ativa")
    private boolean ativa;

    // TODO: Adicionar Objetos DTO agregados.
}
