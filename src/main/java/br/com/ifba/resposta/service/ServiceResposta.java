/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.resposta.service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.resposta.dao.IDaoResposta;
import br.com.ifba.resposta.model.Resposta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ellen Cristina
 */
public class ServiceResposta implements IServiceResposta{
    // Mensagem de erro se a Resposta for null.
    public final static String RESPOSTA_NULL = "Dados da Resposta nao preenchidos";
    // Mensagem de erro se a Resposta já existir.
    public final static String RESPOSTA_EXISTE = "Resposta ja existente no Banco de dados";
    // Mensagem de erro se a Resposta nao existir no banco.
    public final static String RESPOSTA_NAO_EXISTE = "Resposta nao existente no Banco de dados";
    // Mensagem de erro se a Resposta for invalido.
    public final static String RESPOSTA_INVALIDO = "As informacoes da Resposta nao sao validas";
    
    
     //================= OBJETO =================================================
    @Autowired
    private IDaoResposta respostaDao;

    @Override
    public Resposta saveResposta(Resposta resposta) {
        if(resposta == null) {
            throw new BusinessException(RESPOSTA_NULL);
       } else{
            return respostaDao.save(resposta);
       }
    }

    @Override
    public Resposta updateResposta(Resposta resposta) {
        if(resposta == null) {
            throw new BusinessException(RESPOSTA_NULL);
        } 
        if(respostaDao.existsById(resposta.getId()) == false) {
            throw new BusinessException(RESPOSTA_NAO_EXISTE);
        }
        return respostaDao.save(resposta);
    }

    @Override
    public void deleteResposta(Resposta resposta) {
        if(resposta == null) {
            throw new BusinessException(RESPOSTA_NULL);
        } 
        if(respostaDao.existsById(resposta.getId()) == false) {
            throw new BusinessException(RESPOSTA_NAO_EXISTE);
        }
        respostaDao.delete(resposta);
    }

    @Override
    public List<Resposta> getAllQuestao() {
        return this.respostaDao.findAll();
    }
    
}
