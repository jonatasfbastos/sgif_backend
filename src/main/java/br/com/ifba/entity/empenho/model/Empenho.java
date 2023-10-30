package br.com.ifba.entity.empenho.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.item.model.Item;
import br.com.ifba.entity.usuario.model.Usuario;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Esta classe representa um empenho.
 *
 * @author rocki.julius
 * Editado por Andesson Reis
 * @since V1.0.1
 * 
 * Esta classe representa um empenho da organização.
 * Nenhum dos atributos desta classe pode ser nulo.
 * 
 * Veja também: {@link br.com.ifba.entity.item.model.Item}
 * Veja também: {@link br.com.ifba.entity.usuario.model.Usuario}
 */
@Entity(name = "empenho")
@Table(name = "empenhos")
@Data
@EqualsAndHashCode(callSuper = false)
public class Empenho extends PersistenceEntity {

    /**
     * A nota do empenho.
     */
    private String nota;

    /**
     * O criador do empenho.
     */
    @OneToOne
    private Usuario criador;

    /**
     * Itens relacionados ao empenho.
     */
    @OneToMany(mappedBy = "codigoItem")
    @JsonIgnoreProperties("empenho")
    private List<Item> itens;
}
