package br.com.ifba.entity.mensagem.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

/**
 * Esta classe representa uma mensagem.
 *
 * @author felipe
 * @Editado por Andesson Reis
 * @since V1.0.1
 * 
 * Esta classe representa uma mensagem da aplicação.
 * Nenhum dos atributos desta classe pode ser nulo.
 */
@Entity(name = "mensagem")
@Table(name = "mensagens")
@Data
@EqualsAndHashCode(callSuper = false)
public class Mensagem extends PersistenceEntity implements Serializable {

    /**
     * O nome da mensagem. Não pode ser nulo.
     */
    @NotNull
    private String nome;

    /**
     * A descrição da mensagem. Não pode ser nula.
     */
    @NotNull
    private String descricao;

    /**
     * A data de início da mensagem. Não pode ser nula.
     */
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    /**
     * A data de término da mensagem. Não pode ser nula.
     */
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataFim;
}
