package br.com.ifba.sgif.api.entity.tecnicoadministrativo.dto;

import br.com.ifba.sgif.api.entity.funcaotecnicoadministrativo.dto.FuncaoTecnicoAdministrativoResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.sgif.api.entity.funcaoservidor.dto.FuncaoServidorResponseDto;

/**
 * @author Andesson Reis
 * 
 * DTO para enviar dados em resposta a requisições relacionadas à entidade 'TecnicoAdministrativo'.
 *
 * @param funcaoServidor - Informações da função de servidor do técnico administrativo.
 * @param funcaoTecnicoAdministrativo - Informações da função de técnico administrativo do servidor.
 */
public record TecnicoAdministrativoResponseDto(
    @JsonProperty(value = "id")
    Long id,

    @JsonProperty(value = "funcaoServidor")
    FuncaoServidorResponseDto funcaoServidor,

    @JsonProperty(value = "funcaoTecnicoAdministrativo")
    FuncaoTecnicoAdministrativoResponseDto funcaoTecnicoAdministrativo
) {

}
