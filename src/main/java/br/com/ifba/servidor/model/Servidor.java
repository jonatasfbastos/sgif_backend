package br.com.ifba.servidor.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.servidor.model.Servidor;

@Entity
@Table(name = "servidor")

public abstract class Servidor extends PersistenceEntity implements Serializable{
    private String nome;
    private String siape;

}
