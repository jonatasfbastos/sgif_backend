/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.entity.escolhaunica.dao;

import br.com.ifba.entity.escolhaunica.model.EscolhaUnica;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ellen Cristina
 */
public interface IDaoEscolhaUnica extends JpaRepository<EscolhaUnica, Long>{
    
}
