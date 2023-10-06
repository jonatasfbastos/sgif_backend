/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.entity.opcao.service;

import br.com.ifba.entity.opcao.model.Opcao;
import java.util.List;

/**
 *
 * @author Ellen Cristina
 */
public interface IServiceOpcao {
    // Salva Opcao.
    public Opcao saveOpcao(Opcao opcao);
    // Atualiza Opcao.
    public Opcao updateOpcao(Opcao opcao);
    // Deleta Opcao.
    public void deleteOpcao(Opcao opcao);
     // Metodo que retorna todas as Opcao da base de dados.
    public List<Opcao> getAllOpcao();
}
