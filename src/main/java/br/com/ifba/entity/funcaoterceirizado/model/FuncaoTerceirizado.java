package br.com.ifba.entity.funcaoterceirizado.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.terceirizado.model.Terceirizado;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author ph715
 * @since V1.0.1
 * Editado por Andesson Reis
 */
@Entity
@Data
@Table(name = "funcao_terceirizado")
@EqualsAndHashCode(callSuper = false)
public class FuncaoTerceirizado extends PersistenceEntity implements Serializable {
    
    /**
     * O nome da função do terceirizado.
     */
    @Column(nullable = false)
    private String nome;

    /**
     * A descrição da função do terceirizado.
     */
    @Column
    private String descricao;
    
    /**
     * A lista de terceirizados associados a esta função.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcaoTerceirizado")
    private List<Terceirizado> terceirizado;
}
