package br.com.ifba.servidor.model;

import java.io.Serializable;

import br.com.ifba.pessoa.model.Pessoa;

public abstract class Servidor extends Pessoa implements Serializable{
    
    private String siape;
}
