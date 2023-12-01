package br.com.ifba.sgif.api.entity.professor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfessorSimpleResponseDto {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "nome")
    private String nome;
}
