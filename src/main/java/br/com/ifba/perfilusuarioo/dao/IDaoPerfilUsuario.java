/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.perfilusuarioo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.perfilusuarioo.model.PerfilUsuario;

/**
 *
 * @author Igor Lopes e Eduarda
 */
public interface IDaoPerfilUsuario extends JpaRepository<PerfilUsuario, Long> {
   public abstract List<PerfilUsuario> findByNome(String name);
}