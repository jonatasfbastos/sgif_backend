/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package br.com.ifba.pedido.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.pedido.model.Pedido;

/**
 *
 * @author rocki.julius
 */
public interface IDaoPedido extends JpaRepository<Pedido, Long> {

}