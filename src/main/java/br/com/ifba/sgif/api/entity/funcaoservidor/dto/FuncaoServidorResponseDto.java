package br.com.ifba.sgif.api.entity.funcaoservidor.dto;

import java.util.List;

import br.com.ifba.sgif.api.entity.tecnicoadministrativo.dto.TecnicoAdministrativoResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.sgif.api.entity.servidor.dto.ServidorResponseDto;


/**
 * DTO para enviar dados em resposta a requisições relacionadas à entidade 'FuncaoServidor'.
 *
 * @param nome - O nome da função de servidor.
 * @param descricao - A descrição da função de servidor.
 * @param servidores - Lista de servidores associados à função.
 * @param tecnicoAdministrativos - Lista de técnicos administrativos associados à função.
 */
public record FuncaoServidorResponseDto(
    @JsonProperty(value = "id")
    Long id,

    @JsonProperty(value = "nome")
    String nome,

    @JsonProperty(value = "descricao")
    String descricao,

    @JsonProperty(value = "servidores")
    List<ServidorResponseDto> servidores,

    @JsonProperty(value = "tecnicoAdministrativos")
    List<TecnicoAdministrativoResponseDto> tecnicoAdministrativos
) {

}
