package br.com.ifba.entity.requisicao.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.item.model.Item;
import br.com.ifba.entity.setor.model.Setor;
import br.com.ifba.entity.usuario.model.Usuario;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe que representa uma requisição.
 *
 * @author Vitor
 * @Editado por Andesson Reis
 * @since V1.0.1
 * 
 * Esta classe representa uma requisição.
 * 
 * Veja também: {@link br.com.ifba.entity.usuario.model.Usuario}
 */
@Entity(name = "requisicao")
@Table(name = "requisicoes")
@Data
@EqualsAndHashCode(callSuper = false)
public class Requisicao extends PersistenceEntity {

    // =========================================================== //
    // ======================= [ ATRIBUTOS ] ===================== //
    // =========================================================== //

    /**
     * Código de saída da requisição.
     */
    @Column(nullable = false, unique = true)
    private String codigoSaida;

    /**
     * Status da requisição.
     */
    private boolean status;

    /**
     * Quantidade de itens na requisição.
     */
    private int quantidadeItensReq;

    /**
     * Criador da requisição.
     */
    @OneToOne
    @JoinColumn(name = "criador_id")
    private Usuario criador;

    /**
     * Setor da requisição.
     */
    @JsonIgnoreProperties("requisicoes")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "setor_id")
    private Setor setor;

    /**
     * Nome do requisitante da requisição.
     */
    @NotNull
    private String requisitante;

    /**
     * Itens da requisição.
     */
    @ManyToOne
    @JoinColumn(name = "itens_id")
    private Item itens;
}
