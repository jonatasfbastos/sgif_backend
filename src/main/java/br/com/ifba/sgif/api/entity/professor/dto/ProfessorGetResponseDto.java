package br.com.ifba.sgif.api.entity.professor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfessorGetResponseDto {

    @JsonProperty(value = "nome")
    private String nome;

    @JsonProperty(value = "telefone")
    private String telefone;

    @JsonProperty(value = "email")
    private String email;


    @JsonProperty(value = "cpf")
    private String cpf;

    @JsonProperty(value = "data_nascimento")
    private Date dataDeNascimento;

    @JsonProperty(value = "siape")
    private String siape;
}
