/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.statusaluno.service;

import br.com.ifba.aluno.dao.IDaoAluno;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.statusaluno.dao.IDaoStatusAluno;
import br.com.ifba.statusaluno.model.StatusAluno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ellen Cristina
 */
@Service
public class ServiceStatusAluno implements IServiceStatusAluno{
     // Mensagem de erro se o Status for null.
    public final static String STATUS_NULL = "Dados do Status nao preenchidos";
    // Mensagem de erro se o Status ja¡ existir.
    public final static String STATUS_EXISTE = "Status ja existente no Banco de dados";
    // Mensagem de erro se o Status nao existir no banco.
    public final static String STATUS_NAO_EXISTE = "Status nao existente no Banco de dados";
    // Mensagem de erro se o Status for invalido.
    public final static String STATUS_INVALIDO = "As informacoes do Status nao sao validas";
    //mensagem de erro caso exista aluno atrelado a um status
    private final static String ALUNO_EXISTE = "Status não pode ser excluído, pois existe Aluno cadastrado";
    
     //================= OBJETO =================================================
    @Autowired
    private IDaoStatusAluno statusDao;
    private IDaoAluno alunoDao;

     //================= METODOS ================================================

    @Override
    public StatusAluno saveStatus(StatusAluno status) {
         if(status == null) {
            throw new BusinessException(STATUS_NULL);
       } else{
            return statusDao.save(status);
       }
    }

    @Override
    public StatusAluno updateStatus(StatusAluno status) {
        if(status == null) {
            throw new BusinessException(STATUS_NULL);
        } 
        if(statusDao.existsById(status.getId()) == false) {
            throw new BusinessException(STATUS_NAO_EXISTE);
        }
        return statusDao.save(status);
    }

    @Override
    public void deleteStatus(StatusAluno status) {
        if(status == null) {
            throw new BusinessException(STATUS_NULL);
        } 
        if(statusDao.existsById(status.getId()) == false) {
            throw new BusinessException(STATUS_NAO_EXISTE);
        }
        if(statusDao.getReferenceById(status.getId()).getAlunos().isEmpty() == false){
            throw new BusinessException(ALUNO_EXISTE);
        }
        statusDao.delete(status);
    }

    @Override
    public List<StatusAluno> getAllstatus() {
        return this.statusDao.findAll();
    }
    
}
