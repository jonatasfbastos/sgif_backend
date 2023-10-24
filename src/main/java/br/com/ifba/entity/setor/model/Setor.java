package br.com.ifba.entity.setor.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.requisicao.model.Requisicao;
import br.com.ifba.entity.usuario.model.Usuario;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Esta classe representa um setor.
 *
 * @author Everton.
 * Editado por Andesson Reis
 * @since V1.0.1
 * 
 * Esta classe representa um setor da organização.
 * Nenhum dos atributos desta classe pode ser nulo.
 * 
 * Veja também: {@link br.com.ifba.entity.requisicao.model.Requisicao}
 */
@Entity(name = "setor")
@Table(name = "setores")
@Data
@EqualsAndHashCode(callSuper = false)
public class Setor extends PersistenceEntity {
    /**
     * O nome do setor. Não pode ser nulo e deve ser único.
     */
    @Column(nullable = false, unique = true)
    private String nome;

    /**
     * A descrição do setor. Não pode ser nula.
     */
    @Column(nullable = false)
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "setor")
    private List<Requisicao> requisicoes;

    @OneToOne
    private Usuario criador;
}
