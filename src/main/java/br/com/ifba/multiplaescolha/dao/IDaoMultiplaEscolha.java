/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.multiplaescolha.dao;

import br.com.ifba.multiplaescolha.model.MultiplaEscolha;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ellen Cristina
 */
public interface IDaoMultiplaEscolha extends JpaRepository<MultiplaEscolha, Long>{
    
}
