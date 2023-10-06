/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.entity.escolhaunica.service;

import br.com.ifba.entity.escolhaunica.model.EscolhaUnica;

import java.util.List;

/**
 *
 * @author Ellen Cristina
 */
public interface IServiceEscolhaUnica {
    // Salva EscolhaUnica.
    public EscolhaUnica saveEscolhaUnica(EscolhaUnica escolhaunica);
    // Atualiza EscolhaUnica.
    public EscolhaUnica updateEscolhaUnica(EscolhaUnica escolhaunica);
    // Deleta EscolhaUnica.
    public void deleteEscolhaUnica(EscolhaUnica escolhaunica);
     // Metodo que retorna todos as EscolhaUnica da base de dados.
    public List<EscolhaUnica> getAllEscolhaUnica();
}
