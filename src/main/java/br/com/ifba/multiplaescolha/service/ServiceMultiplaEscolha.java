/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.multiplaescolha.service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.multiplaescolha.dao.IDaoMultiplaEscolha;
import br.com.ifba.multiplaescolha.model.MultiplaEscolha;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ellen Cristina
 */
@Service
public class ServiceMultiplaEscolha implements IServiceMultiplaEscolha{
    // Mensagem de erro se a MultiplaEscolha for null.
    public final static String MULTIPLA_ESCOLHA_NULL = "Dados do MultiplaEscolha nao preenchidos";
    // Mensagem de erro se o MultiplaEscolha já existir.
    public final static String MULTIPLA_ESCOLHA_EXISTE = "MultiplaEscolha ja existente no Banco de dados";
    // Mensagem de erro se o MultiplaEscolha não existir no banco.
    public final static String MULTIPLA_ESCOLHA_NAO_EXISTE = "MultiplaEscolha nao existente no Banco de dados";
    
    
     //================= OBJETO =================================================
    @Autowired
    private IDaoMultiplaEscolha multiplaEscolhaDao;

     //================= MÉTODOS ================================================
    @Override
    public MultiplaEscolha saveMultiplaEscolha(MultiplaEscolha multiplaescolha) {
       if(multiplaescolha == null) {
            throw new BusinessException(MULTIPLA_ESCOLHA_NULL);
       } else{
            return multiplaEscolhaDao.save(multiplaescolha);
       }
    }

    @Override
    public MultiplaEscolha updateMultiplaEscolha(MultiplaEscolha multiplaescolha) {
        if(multiplaescolha == null) {
            throw new BusinessException(MULTIPLA_ESCOLHA_NULL);
        } 
        if(multiplaEscolhaDao.existsById(multiplaescolha.getId()) == false) {
            throw new BusinessException(MULTIPLA_ESCOLHA_NAO_EXISTE);
        }
        return multiplaEscolhaDao.save(multiplaescolha);
    }

    @Override
    public void deleteMultiplaEscolha(MultiplaEscolha multiplaescolha) {
        if(multiplaescolha == null) {
            throw new BusinessException(MULTIPLA_ESCOLHA_NULL);
        } 
        if(multiplaEscolhaDao.existsById(multiplaescolha.getId()) == false) {
            throw new BusinessException(MULTIPLA_ESCOLHA_NAO_EXISTE);
        }
        multiplaEscolhaDao.delete(multiplaescolha);
    }

    @Override
    public List<MultiplaEscolha> getAllMultiplaEscolha() {
        return this.multiplaEscolhaDao.findAll();
    }
}
