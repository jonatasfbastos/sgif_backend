/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.entity.respostabinaria.service;

import br.com.ifba.entity.respostabinaria.model.RespostaBinaria;
import java.util.List;

/**
 *
 * @author Ellen Cristina
 */
public interface IServiceRespostaBinaria {
    // Salva RespostaBinaria.
    public RespostaBinaria saveRespostaBinaria(RespostaBinaria respostabinaria);
    // Atualiza RespostaBinaria.
    public RespostaBinaria updateRespostaBinaria(RespostaBinaria respostabinaria);
    // Deleta RespostaBinaria.
    public void deleteRespostaBinaria(RespostaBinaria respostabinaria);
     // Metodo que retorna todas as RespostaBinaria da base de dados.
    public List<RespostaBinaria> getAllRespostaBinaria();
}
