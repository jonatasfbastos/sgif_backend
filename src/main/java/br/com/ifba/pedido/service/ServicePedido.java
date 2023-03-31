/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.pedido.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.pedido.dao.IDaoPedido;
import br.com.ifba.pedido.model.Pedido;

/**
 *
 * @author rocki.julius
 */
@Service
public class ServicePedido implements IServicePedido {

    // Constantes para condições de erro

    // Pedido Null
    public final static String pedido_NULL = "Pedido null";

    // Pedido já existe
    public final static String pedido_EXISTE = "Pedido já existe";

    // Pedido não existente
    public final static String pedido_NAO_EXISTE = "O pedido já existe na base de dados";

    // Pedido inválido
    public final static String pedido_INVALIDO = "Pedido inválido";

    // Criando objeto de instância
    @Autowired
    private IDaoPedido daoPedido;

    @Override
    public Pedido savePedido(Pedido pedido) {
        if (pedido == null) {
            throw new BusinessException(pedido_NULL);
        } else {
            return daoPedido.save(pedido);
        }
    }

    @Override
    public Pedido updatePedido(Pedido pedido) {
        if (pedido == null) {
            throw new BusinessException(pedido_NULL);
        } else if (daoPedido.findById(pedido.getId()) == null) {
            throw new BusinessException(pedido_EXISTE);
        } else {
            return daoPedido.save(pedido);
        }
    }

    @Override
    public void deletePedido(Pedido pedido) {
        if (pedido == null) {
            throw new BusinessException(pedido_NULL);
        } else {
            this.daoPedido.delete(pedido);
            return;
        }
    }

    @Override
    public List<Pedido> getAllPedido() {
        return daoPedido.findAll();
    }
}
