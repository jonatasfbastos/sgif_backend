package br.com.ifba.sgif.api.entity.tipodeitem.model;

import br.com.ifba.sgif.api.entity.item.model.Item;
import br.com.ifba.sgif.api.infrastructure.model.PersistenceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author unknown
 * Editado por Andesson Reis
 * @since V1.0.1
 * 
 * Esta classe representa um tipo de item.
 * Nenhum dos atributos desta classe pode ser nulo.
 * 
 * Veja também: {@link Item}
 */

@Entity(name = "tipoDeItem")
@Table(name = "tipo_de_item")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class TipoDeItem extends PersistenceEntity {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    /**
     * O nome do tipo de item. Não pode ser nulo.
     */

    @Column(nullable = false)
    private String nome;

    /**
     * A descrição do tipo de item.
     */

    @Column
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDeItem")
    private List<Item> itens;
}
