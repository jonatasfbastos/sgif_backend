package br.com.ifba.terceirizado.model;

import br.com.ifba.funcaoterceirizado.model.FuncaoTerceirizado;
import java.io.Serializable;

import javax.persistence.Entity;

import br.com.ifba.pessoa.model.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Terceirizado extends Pessoa implements Serializable{
    @ManyToOne
    @JoinColumn(name = "funcaoTerceirizado_id")
    @JsonIgnoreProperties("terceirizado")
    private FuncaoTerceirizado funcaoTerceirizado;
}
