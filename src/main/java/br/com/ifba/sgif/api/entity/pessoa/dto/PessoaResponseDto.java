package br.com.ifba.sgif.api.entity.pessoa.dto;

import br.com.ifba.sgif.api.entity.requisicao.dto.RequisicaoResponseDto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe que representa um DTO para a entidade 'Pessoa' utilizada na resposta.
 *
 * @author Andesson Reis
 * Desde V1.0.1
 *
 * Este DTO é utilizado para enviar informações de uma pessoa como resposta.
 *
 * @param nome - O nome da pessoa.
 * @param telefone - O telefone da pessoa.
 * @param email - O email da pessoa.
 * @param cpf - O CPF da pessoa.
 * @param dataDeNascimento - A data de nascimento da pessoa.
 * @param requisicoes - A lista de requisições associadas à pessoa.
 */
public record PessoaResponseDto(
        @JsonProperty(value = "id")
        Long id,
        
        @JsonProperty(value = "nome")
        String nome,

        @JsonProperty(value = "telefone")
        String telefone,

        @JsonProperty(value = "email")
        String email,

        @JsonProperty(value = "cpf")
        String cpf,

        @JsonProperty(value = "data_nascimento")
        String dataDeNascimento,

        @JsonProperty(value = "requisicoes")
        List<RequisicaoResponseDto> requisicoes
) {
}
