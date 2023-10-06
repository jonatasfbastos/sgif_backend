/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.entity.setor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.setor.model.Setor;

/**
 *
 * @author Everton.
 */
public interface IDaoSetor extends JpaRepository<Setor, Long> {
   public abstract List<Setor> findByNome(String name);
}
