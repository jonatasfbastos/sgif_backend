/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.entity.funcaoterceirizado.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.terceirizado.model.Terceirizado;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author ph715
 */
@Entity
@Data
@Table(name = "funcao_terceirizado")
@EqualsAndHashCode(callSuper = false)
public class FuncaoTerceirizado extends PersistenceEntity implements Serializable {
    private String nome;
    private String descricao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcaoTerceirizado")
    private List<Terceirizado> terceirizado;
    
}
