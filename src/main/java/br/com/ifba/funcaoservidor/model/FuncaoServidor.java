package br.com.ifba.funcaoservidor.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.servidor.model.Servidor;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.OneToMany;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Gusd
 */
@Entity
@Data
@Table(name = "funcao_servidor")
@EqualsAndHashCode(callSuper = false)
public class FuncaoServidor extends PersistenceEntity implements Serializable {

    private String nome;
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcaoServidor")
    private List<Servidor> servidor;

}