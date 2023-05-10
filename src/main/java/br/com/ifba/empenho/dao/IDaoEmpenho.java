/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package br.com.ifba.empenho.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.empenho.model.Empenho;

/**
 *
 * @author rocki.julius
 */
public interface IDaoEmpenho extends JpaRepository<Empenho, Long> {
    
}