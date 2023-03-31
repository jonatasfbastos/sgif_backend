/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.requisicao.service;

import java.util.List;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.requisicao.dao.IDaoRequisicao;
import br.com.ifba.requisicao.model.Requisicao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vitor
 */
@Service
public class ServiceRequisicao implements IServiceRequisicao {

    // CONSTANTES

    // mensagem de erro se a requisição for null;
    public final static String REQUISICAO_NULL = "Requisição null";

    // mensagem de erro se a Requisição já existir;
    public final static String REQUISICAO_EXISTE = "Requisição já existe,";

    // mensagem de erro se a Requisição não existir no banco;
    public final static String REQUISICAO_NAO_EXISTE = "Requisição não existe na base de dados";

    // mensagem de erro se a Requisição for inválido;
    public final static String REQUISICAO_INVALIDO = "Requisição inválida";

    // OBJETO
    @Autowired
    private IDaoRequisicao daoRequisicao;

    @Override
    public Requisicao saveRequisicao(Requisicao requisicao) {
        if (requisicao == null) {
            throw new BusinessException(REQUISICAO_NULL);
        } else {
            return daoRequisicao.save(requisicao);
        }
    }

    @Override
    public Requisicao updateRequisicao(Requisicao requisicao) {
        if (requisicao == null) {
            throw new BusinessException(REQUISICAO_NULL);
        } else if (daoRequisicao.findById(requisicao.getId()) == null) {
            throw new BusinessException(REQUISICAO_NAO_EXISTE);
        } else {
            return daoRequisicao.save(requisicao);
        }
    }

    @Override
    public void deleteRequisicao(Requisicao requisicao) {
        if (requisicao == null) {
            throw new BusinessException(REQUISICAO_NULL);
        } else {
            this.daoRequisicao.delete(requisicao);
            return;
        }

    }

    @Override
    public List<Requisicao> getAllRequisicao() {
        return this.daoRequisicao.findAll();
    }

}
