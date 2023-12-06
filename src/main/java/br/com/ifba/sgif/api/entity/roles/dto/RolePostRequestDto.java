package br.com.ifba.sgif.api.entity.roles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RolePostRequestDto {

    @JsonProperty(value = "id")
    private int id;

    @JsonProperty(value = "nome")
    private String nomePapel;

}
