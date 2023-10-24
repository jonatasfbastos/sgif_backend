package br.com.ifba.entity.tecnicoadministrativo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.entity.funcaoservidor.dto.FuncaoServidorRequestDto;
import br.com.ifba.entity.funcaotecnicoadministrativo.dto.FuncaoTecnicoAdministrativoRequestDto;

import javax.validation.constraints.NotNull;

/**
 * @author Andesson Reis
 * 
 * DTO para receber dados de requisições direcionadas à entidade 'TecnicoAdministrativo'.
 *
 * @param funcaoServidor - Informações da função de servidor do técnico administrativo.
 * @param funcaoTecnicoAdministrativo - Informações da função de técnico administrativo do servidor.
 */
public class TecnicoAdministrativoRequestDto {

    @JsonProperty(value = "funcaoServidor")
    @NotNull(message = "A função de servidor é obrigatória para o técnico administrativo.")
    private FuncaoServidorRequestDto funcaoServidor;

    @JsonProperty(value = "funcaoTecnicoAdministrativo")
    @NotNull(message = "A função de técnico administrativo é obrigatória para o servidor.")
    private FuncaoTecnicoAdministrativoRequestDto funcaoTecnicoAdministrativo;
}
