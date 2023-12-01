package br.com.ifba.sgif.api.entity.funcaotecnicoadministrativo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.sgif.api.entity.tecnicoadministrativo.dto.TecnicoAdministrativoResponseDto;

import java.util.List;

/**
 * @author Andesson Reis
 * DTO para enviar dados em resposta a requisições relacionadas à entidade 'FuncaoTecnicoAdministrativo'.
 *
 * @param nome - O nome da função de técnico administrativo.
 * @param descricao - A descrição da função de técnico administrativo.
 * @param tecnicos - Lista de técnicos associados à função.
 */
public record FuncaoTecnicoAdministrativoResponseDto(    
    @JsonProperty(value = "id")
    Long id,
    
    @JsonProperty(value = "nome")
    String nome,

    @JsonProperty(value = "descricao")
    String descricao,

    @JsonProperty(value = "tecnicos")
    List<TecnicoAdministrativoResponseDto> tecnicos
    ) {}