/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.opcao.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.multiplaescolha.model.MultiplaEscolha;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Ellen Cristina
 */
@Entity
@Table(name = "opcao")
@Data
@EqualsAndHashCode(callSuper = false)
public class Opcao extends PersistenceEntity implements Serializable{
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "multiplaescolha_id", referencedColumnName = "ID")
    private MultiplaEscolha multiplaEscolha;
}
