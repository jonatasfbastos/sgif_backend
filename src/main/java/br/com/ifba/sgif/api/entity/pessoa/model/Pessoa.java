package br.com.ifba.sgif.api.entity.pessoa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import br.com.ifba.sgif.api.infrastructure.model.PersistenceEntity;
import br.com.ifba.sgif.api.entity.requisicao.model.Requisicao;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author matheus
 *
 * Esta classe represante uma pessoa, um ascendente de diversas outras classes do sistema.
 */
@Entity(name = "pessoa")
@Table(name = "pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@EqualsAndHashCode(callSuper = false)
public class Pessoa extends PersistenceEntity {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    /**
     * O nome da pessoa, não pode ser nulo.
     */
    @Column(name = "nome", nullable = false)
    protected String nome;

    /**
     * O telefone da pessoa,
     * exemplo: (na tabela) 74999999999 -> (com máscara) (74) 99999-9999
     */
    @Column(name = "telefone")
    private String telefone;

    /**
     * O email da pessoa.
     */
    @Column(name = "email")
    private String email;

    /**
     * O CPF (Cadastro de Pessoa Física) da pessoa,
     * não pode ser nulo e deve ser único.
     * Exemplo: (na tabela) 12345678900 -> (com máscara) 123.456.789-00
     */
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    /**
     * A data de nascimento da pessoa.
     */
    @Column(name = "data_nascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNascimento;

    /**
     * A lista com requisições da pessoa.
     */
    @OneToMany(mappedBy = "requisitante")
    private List<Requisicao> requisicoes;
}
