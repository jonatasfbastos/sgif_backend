/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.entity.requisicao.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.requisicao.model.Requisicao;

/**
 *
 * @author Vitor
 */
public interface IDaoRequisicao extends JpaRepository<Requisicao, Long> {
}
