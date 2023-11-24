package br.com.ifba.sgif.api.entity.questao.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ifba.sgif.api.entity.formulario.model.Formulario;
import br.com.ifba.sgif.api.entity.resposta.model.Resposta;
import br.com.ifba.sgif.api.infrastructure.model.PersistenceEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Esta classe representa uma questão de um formulário.
 * Ela contém informações sobre o enunciado da questão e a resposta, sendo que a resposta inicialmente é nula.
 *
 * veja também: {@link Formulario}
 */
@Entity(name = "questao")
@Table(name = "questoes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Questao extends PersistenceEntity implements Serializable{

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //
    /**
     * O enunciado da questão, não aceita valores nulos.
     */
    @Column(name = "enunciado")
    private String enunciado;

    /**
     * O formulario ao qual a questão pertence.
     */
    @ManyToOne
    @JoinColumn(name = "formulario_id", referencedColumnName = "ID")
    private Formulario formulario;

    /**
     * A lista de respostas da questão,
     * cada resposta tem o seu dono, ou seja, quem respondeu.
     */
    @Column(name = "respostas", nullable = false)
    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL)
    private List<Resposta> respostas;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

}
