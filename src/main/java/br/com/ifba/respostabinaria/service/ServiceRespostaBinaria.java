/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.respostabinaria.service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.respostabinaria.dao.IDaoRespostaBinaria;
import br.com.ifba.respostabinaria.model.RespostaBinaria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ellen Cristina
 */
@Service
public class ServiceRespostaBinaria implements IServiceRespostaBinaria{
    // Mensagem de erro se o RespostaBinaria for null.
    public final static String RESPOSTA_BINARIA_NULL = "Dados do RespostaBinaria nao preenchidos";
    // Mensagem de erro se o RespostaBinaria já existir.
    public final static String RESPOSTA_BINARIA_EXISTE = "RespostaBinaria ja existente no Banco de dados";
    // Mensagem de erro se o RespostaBinaria não existir no banco.
    public final static String RESPOSTA_BINARIA_NAO_EXISTE = "RespostaBinaria nao existente no Banco de dados";
    // Mensagem de erro se o RespostaBinaria for inválido.
    public final static String RESPOSTA_BINARIA_INVALIDO = "As informações do RespostaBinaria nao sao validas";
     
    
     //================= OBJETO =================================================
    @Autowired
    private IDaoRespostaBinaria respostaBinariaDao;

     //================= MÉTODOS ================================================
    @Override
    public RespostaBinaria saveRespostaBinaria(RespostaBinaria respostabinaria) {
       if(respostabinaria == null) {
            throw new BusinessException(RESPOSTA_BINARIA_NULL);
       } else{
            return respostaBinariaDao.save(respostabinaria);
       }
    }

    @Override
    public RespostaBinaria updateRespostaBinaria(RespostaBinaria respostabinaria) {
        if(respostabinaria == null) {
            throw new BusinessException(RESPOSTA_BINARIA_NULL);
        } 
        if(respostaBinariaDao.existsById(respostabinaria.getId()) == false) {
            throw new BusinessException(RESPOSTA_BINARIA_NAO_EXISTE);
        }
        return respostaBinariaDao.save(respostabinaria);
    }

    @Override
    public void deleteRespostaBinaria(RespostaBinaria respostabinaria) {
        if(respostabinaria == null) {
            throw new BusinessException(RESPOSTA_BINARIA_NULL);
        } 
        if(respostaBinariaDao.existsById(respostabinaria.getId()) == false) {
            throw new BusinessException(RESPOSTA_BINARIA_NAO_EXISTE);
        }
        respostaBinariaDao.delete(respostabinaria);
    }

    @Override
    public List<RespostaBinaria> getAllRespostaBinaria() {
        return this.respostaBinariaDao.findAll();
    }
}
