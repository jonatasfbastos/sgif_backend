package br.com.ifba.entity.tecnicoadministrativo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.entity.servidor.dto.ServidorResponseDto;
import br.com.ifba.entity.funcaoservidor.dto.FuncaoServidorResponseDto;

/**
 * @author Andesson Reis
 * 
 * DTO para enviar dados em resposta a requisições relacionadas à entidade 'TecnicoAdministrativo'.
 *
 * @param funcaoServidor - Informações da função de servidor do técnico administrativo.
 * @param funcaoTecnicoAdministrativo - Informações da função de técnico administrativo do servidor.
 */
public class TecnicoAdministrativoResponseDto {

    @JsonProperty(value = "funcaoServidor")
    private FuncaoServidorResponseDto funcaoServidor;

    @JsonProperty(value = "funcaoTecnicoAdministrativo")
    private FuncaoTecnicoAdministrativoResponseDto funcaoTecnicoAdministrativo;
}
