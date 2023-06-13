/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.resposta.service;

import br.com.ifba.resposta.model.Resposta;
import java.util.List;

/**
 *
 * @author Ellen Cristina
 */
public interface IServiceResposta {
    //salva a Resposta
    public abstract Resposta saveResposta(Resposta resposta);
    
    //atualiza a Resposta
    public abstract Resposta updateResposta(Resposta resposta);
    
    //deleta a Resposta
    public abstract void deleteResposta(Resposta resposta);
    
    // Metodo que retorna todas as Resposta da base de dados
    public abstract List<Resposta> getAllQuestao();
}
