package br.com.ifba.entity.terceirizado.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.ifba.entity.funcaoterceirizado.model.FuncaoTerceirizado;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Esta classe representa um terceirizado.
 * Nenhum dos atributos desta classe pode ser nulo.
 * 
 * Veja também: {@link br.com.ifba.entity.funcaoterceirizado.model.FuncaoTerceirizado}
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Terceirizado extends PersistenceEntity implements Serializable {
    
    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //
    
    /**
     * A função do terceirizado. Não pode ser nula.
     */
    @ManyToOne
    @JoinColumn(name = "funcaoTerceirizado_id")
    @JsonIgnoreProperties("terceirizados")
    private FuncaoTerceirizado funcaoTerceirizado;
}
