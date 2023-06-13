/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.opcao.service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.opcao.dao.IDaoOpcao;
import br.com.ifba.opcao.model.Opcao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ellen Cristina
 */
public class ServiceOpcao implements IServiceOpcao{
    // Mensagem de erro se o Opcao for null.
    public final static String OPCAO_NULL = "Dados do Opcao nao preenchidos";
    // Mensagem de erro se o Opcao já existir.
    public final static String OPCAO_EXISTE = "Opcao ja existente no Banco de dados";
    // Mensagem de erro se o Opcao não existir no banco.
    public final static String OPCAO_NAO_EXISTE = "Opcao nao existente no Banco de dados";
    // Mensagem de erro se o Opcao for inválido.
    public final static String OPCAO_INVALIDO = "As informações do Opcao nao sao validas";
     
    
     //================= OBJETO =================================================
    @Autowired
    private IDaoOpcao opcaoDao;

     //================= MÉTODOS ================================================
    @Override
    public Opcao saveOpcao(Opcao opcao) {
       if(opcao == null) {
            throw new BusinessException(OPCAO_NULL);
       } else{
            return opcaoDao.save(opcao);
       }
    }

    @Override
    public Opcao updateOpcao(Opcao opcao) {
        if(opcao == null) {
            throw new BusinessException(OPCAO_NULL);
        } 
        if(opcaoDao.existsById(opcao.getId()) == false) {
            throw new BusinessException(OPCAO_NAO_EXISTE);
        }
        return opcaoDao.save(opcao);
    }

    @Override
    public void deleteOpcao(Opcao opcao) {
        if(opcao == null) {
            throw new BusinessException(OPCAO_NULL);
        } 
        if(opcaoDao.existsById(opcao.getId()) == false) {
            throw new BusinessException(OPCAO_NAO_EXISTE);
        }
        opcaoDao.delete(opcao);
    }

    @Override
    public List<Opcao> getAllOpcao() {
        return this.opcaoDao.findAll();
    }
}
