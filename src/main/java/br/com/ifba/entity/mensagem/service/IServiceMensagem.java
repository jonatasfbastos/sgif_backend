/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.entity.mensagem.service;

import br.com.ifba.entity.mensagem.model.Mensagem;

import java.util.List;

/**
 *
 * @author felipe
 */
public interface IServiceMensagem {
    // Salva Mensagem
     public abstract Mensagem saveMensagem(Mensagem mensagem);
     // Atualiza Mensagem
     public abstract Mensagem updateMensagem(Mensagem mensagem);
     // Deleta Mensagem
     public abstract void deleteMensagem(Mensagem mensagem);
      // Metodo que retorna todos as Mensagem salvos no base de dados
     public abstract List<Mensagem> getAllMensagem();
     // Metodo que retorna a Mensagem com o id informado
     public Mensagem findById(Long id);
     // Metodo que retorna a lista com as Mensagem com o nome informado
     public List<Mensagem> findByNome(String nome);
}
