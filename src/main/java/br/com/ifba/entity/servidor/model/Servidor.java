package br.com.ifba.entity.servidor.model;
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

@Entity
@Table(name = "servidor")
@Data
@EqualsAndHashCode(callSuper = false)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public abstract class Servidor extends Pessoa implements Serializable {

    private String siape;

    @ManyToOne
    @JoinColumn(name = "funcaoServidor_id")
    @JsonIgnoreProperties("servidor")
    private FuncaoServidor funcaoServidor;

}
