package br.com.ifba.entity.tipodeitem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.item.model.Item;

import java.util.List;

@Entity
@Table(name = "tipoDeItem")
@Data
@EqualsAndHashCode(callSuper = false)
public class TipoDeItem extends PersistenceEntity {
    private String nome;
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDeItem")
    // @JoinColumn(name = "tipodeitens_id")
    private List<Item> itens;

}
