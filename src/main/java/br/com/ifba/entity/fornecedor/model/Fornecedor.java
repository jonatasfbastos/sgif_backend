package br.com.ifba.entity.fornecedor.model;

import br.com.ifba.entity.item.model.Item;
import br.com.ifba.entity.usuario.model.Usuario;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

/**
 * Esta classe representa um fornecedor.
 * 
 * @author vitor
 * @Editado por Andesson Reis
 * @since V1.0.1
 */
@Entity(name = "fornecedor")
@Table(name = "fornecedores")
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Fornecedor extends PersistenceEntity {

    /**
     * O nome do fornecedor. Não pode ser nulo.
     */
    @Column(nullable = false)
    private String nome;

    /**
     * O email do fornecedor. Não pode ser nulo.
     */
    @Column(nullable = false)
    private String email;

    /**
     * O CNPJ do fornecedor. Não pode ser nulo.
     */
    @Column(nullable = false, unique = true)
    private String cnpj;

    /**
     * O telefone do fornecedor. Não pode ser nulo.
     */
    @Column(nullable = false)
    private String telefone;

    /**
     * A inscrição estadual do fornecedor. Não pode ser nula.
     */
    @Column(nullable = false)
    private String inscricaoEstadual;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedor")
    private List<Item> itens;

    @OneToOne
    private Usuario criador;
}
