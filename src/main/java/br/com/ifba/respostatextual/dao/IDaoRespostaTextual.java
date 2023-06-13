/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.respostatextual.dao;

import br.com.ifba.respostatextual.model.RespostaTextual;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ellen Cristina
 */
public interface IDaoRespostaTextual extends JpaRepository<RespostaTextual, Long>{
    
}
