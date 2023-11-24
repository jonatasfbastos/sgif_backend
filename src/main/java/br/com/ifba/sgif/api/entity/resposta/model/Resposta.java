package br.com.ifba.sgif.api.entity.resposta.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.ifba.sgif.api.entity.usuario.model.Usuario;
import br.com.ifba.sgif.api.infrastructure.model.PersistenceEntity;
import br.com.ifba.sgif.api.entity.questao.model.Questao;
import br.com.ifba.sgif.api.entity.formulario.model.Formulario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Entidade que representa as resposta dos enunciados do formulário.
 * veja também: {@link Formulario}
 * veja também: {@link Questao}
 *
 */
@Entity(name = "resposta")
@Table(name = "respostas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Resposta extends PersistenceEntity implements Serializable{

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    /**
     * O conteúdo da resposta, não pode ser nulo.
     */
    @Column(name = "texto", nullable = false)
    String texto;


    /**
     * A questão a qual a resposta pertence.
     */
    @ManyToOne
    @JoinColumn(name = "questao_id", referencedColumnName = "ID")
    private Questao questao;

    /**
     * O dono da resposta.
     */
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "ID")
    private Usuario usuario;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

}
