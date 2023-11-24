package br.com.ifba.sgif.api.entity.funcaotecnicoadministrativo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ifba.sgif.api.entity.tecnicoadministrativo.dto.TecnicoAdministrativoRequestDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Andesson Reis
 * DTO para receber dados de requisições direcionadas à entidade 'FuncaoTecnicoAdministrativo'.
 *
 * @param nome - O nome da função de técnico administrativo (não pode ser nulo).
 * @param descricao - A descrição da função de técnico administrativo.
 * @param tecnicos - Lista de técnicos associados à função.
 */
public class FuncaoTecnicoAdministrativoRequestDto {

    @JsonProperty(value = "nome")
    @NotNull(message = "O nome da função de técnico administrativo é obrigatório.")
    @NotBlank(message = "O nome da função de técnico administrativo não pode ser vazio.")
    private String nome;

    @JsonProperty(value = "descricao")
    private String descricao;

    @JsonProperty(value = "tecnicos")
    private List<TecnicoAdministrativoRequestDto> tecnicos;
}
