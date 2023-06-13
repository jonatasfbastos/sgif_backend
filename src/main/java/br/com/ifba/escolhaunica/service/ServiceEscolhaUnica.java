/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.escolhaunica.service;

import br.com.ifba.escolhaunica.dao.IDaoEscolhaUnica;
import br.com.ifba.escolhaunica.model.EscolhaUnica;
import br.com.ifba.infrastructure.exception.BusinessException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ellen Cristina
 */
public class ServiceEscolhaUnica implements IServiceEscolhaUnica{
    // Mensagem de erro se a EscolhaUnica for null.
    public final static String ESCOLHA_UNICA_NULL = "Dados do EscolhaUnica nao preenchidos";
    // Mensagem de erro se a EscolhaUnica já existir.
    public final static String ESCOLHA_UNICA_EXISTE = "EscolhaUnica ja existente no Banco de dados";
    // Mensagem de erro se a EscolhaUnica não existir no banco.
    public final static String ESCOLHA_UNICA_NAO_EXISTE = "EscolhaUnica nao existente no Banco de dados";
    // Mensagem de erro se a EscolhaUnica for inválido.
    public final static String ESCOLHA_UNICA_INVALIDO = "As informações da EscolhaUnica nao sao validas";
     
    
     //================= OBJETO =================================================
    @Autowired
    private IDaoEscolhaUnica escolhaunicaDao;

     //================= MÉTODOS ================================================
    @Override
    public EscolhaUnica saveEscolhaUnica(EscolhaUnica escolhaunica) {
       if(escolhaunica == null) {
            throw new BusinessException(ESCOLHA_UNICA_NULL);
       } else{
            return escolhaunicaDao.save(escolhaunica);
       }
    }

    @Override
    public EscolhaUnica updateEscolhaUnica(EscolhaUnica escolhaunica) {
        if(escolhaunica == null) {
            throw new BusinessException(ESCOLHA_UNICA_NULL);
        } 
        if(escolhaunicaDao.existsById(escolhaunica.getId()) == false) {
            throw new BusinessException(ESCOLHA_UNICA_NAO_EXISTE);
        }
        return escolhaunicaDao.save(escolhaunica);
    }

    @Override
    public void deleteEscolhaUnica(EscolhaUnica escolhaunica) {
        if(escolhaunica == null) {
            throw new BusinessException(ESCOLHA_UNICA_NULL);
        } 
        if(escolhaunicaDao.existsById(escolhaunica.getId()) == false) {
            throw new BusinessException(ESCOLHA_UNICA_NAO_EXISTE);
        }
        escolhaunicaDao.delete(escolhaunica);
    }

    @Override
    public List<EscolhaUnica> getAllEscolhaUnica() {
        return this.escolhaunicaDao.findAll();
    }
}
