/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.entity.fornecedor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ifba.entity.fornecedor.model.Fornecedor;

/**
 *
 * @author vitor
 */
@Service
public interface IServiceFornecedor {
    public abstract Fornecedor saveFornecedor(Fornecedor fornecedor);

    public abstract Fornecedor updateFornecedor(Fornecedor fornecedor);

    public abstract void deleteFornecedor(Fornecedor fornecedor);

    public abstract List<Fornecedor> getAllFornecedor();

}
