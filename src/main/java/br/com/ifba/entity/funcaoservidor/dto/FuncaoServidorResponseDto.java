package br.com.ifba.entity.funcaoservidor.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.entity.servidor.dto.ServidorResponseDto;
import br.com.ifba.entity.tecnicoadministrativo.dto.TecnicoAdministrativoResponseDto;


/**
 * DTO para enviar dados em resposta a requisições relacionadas à entidade 'FuncaoServidor'.
 *
 * @param nome - O nome da função de servidor.
 * @param descricao - A descrição da função de servidor.
 * @param servidores - Lista de servidores associados à função.
 * @param tecnicoAdministrativos - Lista de técnicos administrativos associados à função.
 */
public class FuncaoServidorResponseDto {

    @JsonProperty(value = "nome")
    private String nome;

    @JsonProperty(value = "descricao")
    private String descricao;

    @JsonProperty(value = "servidores")
    private List<ServidorResponseDto> servidores;

    @JsonProperty(value = "tecnicoAdministrativos")
    private List<TecnicoAdministrativoResponseDto> tecnicoAdministrativos;
}
