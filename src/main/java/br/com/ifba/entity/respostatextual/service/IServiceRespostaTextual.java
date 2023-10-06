/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.entity.respostatextual.service;

import br.com.ifba.entity.respostatextual.model.RespostaTextual;
import java.util.List;

/**
 *
 * @author Ellen Cristina
 */
public interface IServiceRespostaTextual {
    // Salva RespostaTextual.
    public RespostaTextual saveRespostaTextual(RespostaTextual respostatextual);
    // Atualiza RespostaTextual.
    public RespostaTextual updateRespostaTextual(RespostaTextual respostatextual);
    // Deleta RespostaTextual.
    public void deleteRespostaTextual(RespostaTextual respostatextual);
     // Metodo que retorna todas as RespostaTextual da base de dados.
    public List<RespostaTextual> getAllRespostaTextual();
}
