package br.com.ifba.entity.requisicao.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.item.model.Item;
import br.com.ifba.entity.setor.model.Setor;
import br.com.ifba.entity.usuario.model.Usuario;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Vitor
 * Editado por Andesson Reis, Giovane Neves
 * @since Desde V1.0.1
 * <p>
 * Esta classe representa uma requisição.
 * <p>
 * Veja também: {@link br.com.ifba.entity.usuario.model.Usuario}
 */
@Entity(name = "requisicao")
@Table(name = "requisicoes")
@Data
@EqualsAndHashCode(callSuper = false)
public class Requisicao extends PersistenceEntity {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    /**
     * Código de saída da requisição.
     */
    @Column(name = "codigo_saida", nullable = false, unique = true)
    private String codigoSaida;

    /**
     * Status da requisição.
     */
    @Column(name = "status")
    private boolean status;

    /**
     * Quantidade de itens na requisição.
     */
    @Column(name = "quantidade_itens_req")
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
