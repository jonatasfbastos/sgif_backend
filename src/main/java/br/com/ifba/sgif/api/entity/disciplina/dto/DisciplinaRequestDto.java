package br.com.ifba.sgif.api.entity.disciplina.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Giovane Neves
 * @since V1.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DisciplinaRequestDto {

    @JsonProperty(value = "nome")
    private String nome;

    @JsonProperty(value = "descricao")
    private String descricao;

    @JsonProperty(value = "codigo")
    private String codigo;

    @JsonProperty(value = "carga_horaria")
    private int cargaHoraria;

}
