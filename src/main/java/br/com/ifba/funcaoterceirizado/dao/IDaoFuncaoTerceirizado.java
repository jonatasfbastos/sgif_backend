/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.funcaoterceirizado.dao;

import br.com.ifba.funcaoterceirizado.model.FuncaoTerceirizado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ph715
 */
public interface IDaoFuncaoTerceirizado extends JpaRepository<FuncaoTerceirizado, Long> {
    boolean existsByNome(String nome);
    boolean existsById(Long id);
}
