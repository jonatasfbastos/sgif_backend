package br.com.ifba.sgif.api.entity.funcaoservidor.dto;

import br.com.ifba.sgif.api.entity.tecnicoadministrativo.dto.TecnicoAdministrativoRequestDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.sgif.api.entity.servidor.dto.ServidorRequestDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 
 * @author Andesson Reis
 * @since V1.0.1
 * DTO para receber dados de requisições direcionadas à entidade 'FuncaoServidor'.
 *
 * @param nome - O nome da função de servidor (não pode ser nulo).
 * @param descricao - A descrição da função de servidor.
 * @param servidores - Lista de servidores associados à função.
 * @param tecnicoAdministrativos - Lista de técnicos administrativos associados à função.
 */
public record FuncaoServidorRequestDto(
        @JsonProperty(value = "nome")
        @NotNull(message = "O nome da função de servidor é obrigatório.")
        @NotBlank(message = "O nome da função de servidor não pode ser vazio.")
        String nome,

        @JsonProperty(value = "descricao")
        String descricao,

        @JsonProperty(value = "servidores")
        List<ServidorRequestDto> servidores,

        @JsonProperty(value = "tecnicoAdministrativos")
        List<TecnicoAdministrativoRequestDto> tecnicoAdministrativos
) {
}
