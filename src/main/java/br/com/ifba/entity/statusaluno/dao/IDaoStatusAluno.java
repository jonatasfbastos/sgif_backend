/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.entity.statusaluno.dao;

import br.com.ifba.entity.statusaluno.model.StatusAluno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ellen Cristina
 */
public interface IDaoStatusAluno extends JpaRepository<StatusAluno, Long> {
    
}
