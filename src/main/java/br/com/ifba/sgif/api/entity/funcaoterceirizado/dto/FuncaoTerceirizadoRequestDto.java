package br.com.ifba.sgif.api.entity.funcaoterceirizado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ifba.sgif.api.entity.terceirizado.dto.TerceirizadoRequestDto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * DTO para receber dados de requisições direcionadas à entidade 'FuncaoTerceirizado'.
 *
 * @param nome - O nome da função do terceirizado.
 * @param descricao - A descrição da função do terceirizado.
 * @param terceirizados - Lista de terceirizados associados a esta função.
 */
public record FuncaoTerceirizadoRequestDto(
        @JsonProperty(value = "nome")
        @NotNull(message = "O nome é obrigatório.")
        @NotBlank(message = "O nome não pode ser vazio.")
        @Size(min = 3, max = 150, message = "O nome precisa ter pelo menos 3 caracteres e 150 no máximo.")
        String nome,

        @NotNull(message = "A descricao é obrigatório.")
        @NotBlank(message = "A descricao não pode ser vazio.")
        @JsonProperty(value = "descricao")
        String descricao,

        @JsonProperty(value = "terceirizados")
        List<TerceirizadoRequestDto> terceirizados
) {
}
