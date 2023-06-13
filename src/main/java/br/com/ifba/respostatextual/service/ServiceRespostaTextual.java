/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.respostatextual.service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.respostatextual.dao.IDaoRespostaTextual;
import br.com.ifba.respostatextual.model.RespostaTextual;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ellen Cristina
 */
public class ServiceRespostaTextual implements IServiceRespostaTextual{
    // Mensagem de erro se o RespostaTextual for null.
    public final static String RESPOSTA_TEXTUAL_NULL = "Dados do RespostaTextual nao preenchidos";
    // Mensagem de erro se o RespostaTextual já existir.
    public final static String RESPOSTA_TEXTUAL_EXISTE = "RespostaTextual ja existente no Banco de dados";
    // Mensagem de erro se o RespostaTextual não existir no banco.
    public final static String RESPOSTA_TEXTUAL_NAO_EXISTE = "RespostaTextual nao existente no Banco de dados";
    // Mensagem de erro se o RespostaTextual for inválido.
    public final static String RESPOSTA_TEXTUAL_INVALIDO = "As informações do RespostaTextual nao sao validas";
     
    
     //================= OBJETO =================================================
    @Autowired
    private IDaoRespostaTextual respostaTextualDao;

     //================= MÉTODOS ================================================
    @Override
    public RespostaTextual saveRespostaTextual(RespostaTextual respostatextual) {
       if(respostatextual == null) {
            throw new BusinessException(RESPOSTA_TEXTUAL_NULL);
       } else{
            return respostaTextualDao.save(respostatextual);
       }
    }

    @Override
    public RespostaTextual updateRespostaTextual(RespostaTextual respostatextual) {
        if(respostatextual == null) {
            throw new BusinessException(RESPOSTA_TEXTUAL_NULL);
        } 
        if(respostaTextualDao.existsById(respostatextual.getId()) == false) {
            throw new BusinessException(RESPOSTA_TEXTUAL_NAO_EXISTE);
        }
        return respostaTextualDao.save(respostatextual);
    }

    @Override
    public void deleteRespostaTextual(RespostaTextual respostatextual) {
        if(respostatextual == null) {
            throw new BusinessException(RESPOSTA_TEXTUAL_NULL);
        } 
        if(respostaTextualDao.existsById(respostatextual.getId()) == false) {
            throw new BusinessException(RESPOSTA_TEXTUAL_NAO_EXISTE);
        }
        respostaTextualDao.delete(respostatextual);
    }

    @Override
    public List<RespostaTextual> getAllRespostaTextual() {
        return this.respostaTextualDao.findAll();
    }
}
