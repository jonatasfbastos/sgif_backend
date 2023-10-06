package br.com.ifba.entity.funcaoservidor.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.servidor.model.Servidor;
import br.com.ifba.entity.tecnicoadministrativo.model.TecnicoAdministrativo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.OneToMany;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import javax.persistence.FetchType;

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
    
    @JsonIgnore
    @OneToMany(mappedBy = "funcao", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TecnicoAdministrativo> tecnicoAdministrativos; 

}