/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.fornecedor.dao;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.fornecedor.model.Fornecedor;

/**
 *
 * @author vitor
 */
public interface IDaoFornecedor extends JpaRepository<Fornecedor, Long> {

}
