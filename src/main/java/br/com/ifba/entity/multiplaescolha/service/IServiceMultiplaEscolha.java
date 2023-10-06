/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.entity.multiplaescolha.service;

import br.com.ifba.entity.multiplaescolha.model.MultiplaEscolha;

import java.util.List;

/**
 *
 * @author Ellen Cristina
 */
public interface IServiceMultiplaEscolha {
    // Salva MultiplaEscolha.
    public MultiplaEscolha saveMultiplaEscolha(MultiplaEscolha multiplaescolha);
    // Atualiza MultiplaEscolha.
    public MultiplaEscolha updateMultiplaEscolha(MultiplaEscolha multiplaescolha);
    // Deleta MultiplaEscolha.
    public void deleteMultiplaEscolha(MultiplaEscolha multiplaescolha);
     // Metodo que retorna todos as MultiplaEscolha da base de dados.
    public List<MultiplaEscolha> getAllMultiplaEscolha();
}
