package br.com.ifba.entity.funcaotecnicoadministrativo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.entity.tecnicoadministrativo.dto.TecnicoAdministrativoResponseDto;

import java.util.List;

/**
 * @author Andesson Reis
 * DTO para enviar dados em resposta a requisições relacionadas à entidade 'FuncaoTecnicoAdministrativo'.
 *
 * @param nome - O nome da função de técnico administrativo.
 * @param descricao - A descrição da função de técnico administrativo.
 * @param tecnicos - Lista de técnicos associados à função.
 */
public class FuncaoTecnicoAdministrativoResponseDto {

    @JsonProperty(value = "nome")
    private String nome;

    @JsonProperty(value = "descricao")
    private String descricao;

    @JsonProperty(value = "tecnicos")
    private List<TecnicoAdministrativoResponseDto> tecnicos;
}
