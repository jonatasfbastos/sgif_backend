package br.com.ifba.terceirizado.model;

import java.io.Serializable;

import javax.persistence.Entity;

import br.com.ifba.pessoa.model.Pessoa;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Terceirizado extends Pessoa implements Serializable{
    
}
