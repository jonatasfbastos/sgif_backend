package br.com.ifba.sgif.api.entity.disciplina.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Giovane Neves
 * @since V1.0.1
 */
public record DisciplinaResponseDto( 
    @JsonProperty(value = "id")
    Long id
) 
{
       
    // TODO: Adicionar atributos do DTO

}
