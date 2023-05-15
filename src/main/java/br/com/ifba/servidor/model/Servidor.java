package br.com.ifba.servidor.model;

import java.io.Serializable;

import br.com.ifba.pessoa.model.Pessoa;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.ifba.funcaoservidor.model.FuncaoServidor;
import br.com.ifba.servidor.model.Servidor;
import lombok.Data;

@Entity
@Table(name = "servidor")
@Data

public abstract class Servidor extends Pessoa implements Serializable{
    
    @ManyToMany
    private List<FuncaoServidor> funcaoServidor;
    private String siape;
}
