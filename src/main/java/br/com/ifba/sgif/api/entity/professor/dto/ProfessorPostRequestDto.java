package br.com.ifba.sgif.api.entity.professor.dto;

import br.com.ifba.sgif.api.entity.disciplina.dto.DisciplinaRequestDto;
import br.com.ifba.sgif.api.entity.funcaoservidor.dto.FuncaoServidorRequestDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * DTO que recebe requisições POST para cadastrar
 * novos professores com os dados passados no corpo da
 * requisição.
 *
 * @author Giovane Neves
 * @since Desde V1.0.1
 * @param nome O nome do professor.
 * @param telefone O telefone do professor.
 * @param cpf O CPF do professor.
 * @param dataDeNascimento A data de nascimento do professor.
 * @param funcaoServidor A função do servidor.
 * @param siape O siape do professor, deve ser um valor único.
 * @param disciplinas As disciplinas que o professor é responsável.
 */
public record ProfessorPostRequestDto(

        @JsonProperty(value = "nome")
        @NotNull(message = "o nome do professor não pode ser nulo")
        @NotBlank(message = "o nome do professor não pode ser vazio")
        String nome,

        @JsonProperty(value = "telefone")
        @NotNull(message = "o telefone do professor não pode ser nulo")
        @NotBlank(message = "o telefone do professor não pode ser vazio")
        String telefone,

        @JsonProperty(value = "cpf")
        @NotNull(message = "o cpf do professor não pode ser nulo")
        @NotBlank(message = "o cpf do professor não pode ser vazio")
        String cpf,

        @JsonProperty(value = "data_de_nascimento")
        String dataDeNascimento,

        // TODO: Verificar se é necessário adicionar a lista de requisições.

        @JsonProperty(value = "funcao_servidor")
        FuncaoServidorRequestDto funcaoServidor,

        @JsonProperty(value = "siape")
        @NotNull(message = "o siape do professor não pode ser nulo")
        @NotBlank(message = "o siape do professor não pode ser vazio")
        String siape,

        @JsonProperty(value = "disciplinas")
        List<DisciplinaRequestDto> disciplinas

){

}
