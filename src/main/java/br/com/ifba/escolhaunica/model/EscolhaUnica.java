/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.escolhaunica.model;

import br.com.ifba.multiplaescolha.model.MultiplaEscolha;
import br.com.ifba.opcao.model.Opcao;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Ellen Cristina
 */
@Entity
@Table(name = "escolha_unica")
@Data
@EqualsAndHashCode(callSuper = false)
public class EscolhaUnica extends MultiplaEscolha{
    private Opcao opcaoSelecionada;
            
}
