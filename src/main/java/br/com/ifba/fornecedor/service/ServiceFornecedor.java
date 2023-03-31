/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ifba.fornecedor.dao.IDaoFornecedor;
import br.com.ifba.fornecedor.model.Fornecedor;
import br.com.ifba.infrastructure.exception.BusinessException;

/**
 *
 * @author vitor
 */
@Service
public class ServiceFornecedor implements IServiceFornecedor {

    // Constantes para condições de erro

    // Fornecedor Null
    public final static String FORNECEDOR_NULL = "Fornecedor null";

    // Fornecedor já existe
    public final static String FORNECEDOR_EXISTE = "Fornecedor já existe";

    // Fornecedor não existente
    public final static String FORNECEDOR_NAO_EXISTE = "O Fornecedor já existe na base de dados";

    // Fornecedor inválido
    public final static String FORNECEDOR_INVALIDO = "Fornecedor inválido";

    // Criando objeto de instância
    @Autowired
    private IDaoFornecedor daoFornecedor;

    @Override
    public Fornecedor saveFornecedor(Fornecedor fornecedor) {
        if (fornecedor == null) {
            throw new BusinessException(FORNECEDOR_NULL);
        } else {
            return daoFornecedor.save(fornecedor);
        }
    }

    @Override
    public Fornecedor updateFornecedor(Fornecedor fornecedor) {
        if (fornecedor == null) {
            throw new BusinessException(FORNECEDOR_NULL);
        } else if (daoFornecedor.findById(fornecedor.getId()) == null) {
            throw new BusinessException(FORNECEDOR_EXISTE);
        } else {
            return daoFornecedor.save(fornecedor);
        }
    }

    @Override
    public void deleteFornecedor(Fornecedor fornecedor) {
        if (fornecedor == null) {
            throw new BusinessException(FORNECEDOR_NULL);
        } else {
            this.daoFornecedor.delete(fornecedor);
            return;
        }
    }

    @Override
    public List<Fornecedor> getAllFornecedor() {
        return daoFornecedor.findAll();
    }

}
