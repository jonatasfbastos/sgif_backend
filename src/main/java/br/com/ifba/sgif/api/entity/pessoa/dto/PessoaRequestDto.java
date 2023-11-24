package br.com.ifba.sgif.api.entity.pessoa.dto;

import br.com.ifba.sgif.api.entity.requisicao.dto.RequisicaoRequestDto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Giovane Neves
 *
 * Este DTO recebe informações de requisições direcionada à
 * entidade 'Pessoa'.
 *
 * @param nome - O nome da pessoa, não pode ser nulo.
 * @param telefone - O telefone da pessoa.
 * @param email - O email da pessoa.
 * @param cpf - O CPF da pessoa, não pode ser nulo.
 * @param dataDeNascimento - A data de nascimento da pessoa,
 * @param requisicoes - A lista de requisições da pessoa.
 */
public record PessoaRequestDto (
        @JsonProperty(value = "nome")
        @NotNull(message = "O nome da pessoa é obrigatório")
        @NotBlank(message = "O nome da pessoa não pode ser vazio")
        @Size(min = 2, message = "O nome da pessoa deve ter pelo menos 3 caracteres.")
        String nome,

        @JsonProperty(value = "telefone")
        String telefone,

        @JsonProperty(value = "email")
        String email,

        @JsonProperty(value = "cpf")
        @NotNull(message = "O CPF da pessoa é obrigatório")
        @NotBlank(message = "O CPF não pode ser vazio")
        @Size(min = 11, max = 12, message = "O CPF deve ter o total de 11 digitos")
        String cpf,

        @JsonProperty(value = "data_nascimento")
        @NotNull(message = "A data de nascimento é obrigatória")
        @NotBlank(message = "A data de nascimento não pode ser vazia")
        String dataDeNascimento,

        @JsonProperty(value = "requisicoes")
        List<RequisicaoRequestDto> requisicoes
){

}
