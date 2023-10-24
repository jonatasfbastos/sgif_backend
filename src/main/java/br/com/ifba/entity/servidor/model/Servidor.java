package br.com.ifba.entity.servidor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import br.com.ifba.entity.funcaoservidor.model.FuncaoServidor;
import br.com.ifba.entity.pessoa.model.Pessoa;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Esta classe representa um servidor.
 *
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
 * 
 * Esta classe representa um servidor da organização.
 * Nenhum dos atributos desta classe pode ser nulo.
 * 
 * Veja também: {@link br.com.ifba.entity.funcaoservidor.model.FuncaoServidor}
 */
@Entity(name = "servidor")
@Table(name = "servidores")
@Data
@EqualsAndHashCode(callSuper = false)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public abstract class Servidor extends Pessoa implements Serializable {

    /**
     * O número do SIAPE do servidor. Não pode ser nula. Unico
     */
    @Column(nullable = false, unique = true)
    private String siape;

    /**
     * A função do servidor. Não pode ser nula.
     */
    @ManyToOne
    @JoinColumn(name = "funcaoServidor_id")
    @JsonIgnoreProperties("servidores")
    private FuncaoServidor funcaoServidor;
}
