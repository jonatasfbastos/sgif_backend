package br.com.ifba.disciplina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.disciplina.dao.IDaoDisciplina;
import br.com.ifba.disciplina.model.Disciplina;
import br.com.ifba.infrastructure.exception.BusinessException;

@Service
public class ServiceDisciplina implements IServiceDisciplina{
    //mensagem de erro se o Disciplina for null;
    public final static String DISCIPLINA_NULL = "Dados do Disciplina nÃ£o preenchidos";
    
    //mensagem de erro se o Disciplina jÃ¡ existir;
    public final static String DISCIPLINA_EXISTE = "Disciplina ja existente no Banco de dados";
    
    //mensagem de erro se o Disciplina nÃ£o existir no banco;
    public final static String DISCIPLINA_NAO_EXISTE = "Disciplina nao existente no Banco de dados";
    
    //mensagem de erro se o Disciplina for invÃ¡lido;
    public final static String DISCIPLINA_INVALIDO = "As informaÃ§oes do Disciplina nao sao validas";
    
    @Autowired
     private IDaoDisciplina disciplinaDao;
     
     @Override
    public Disciplina saveDisciplina(Disciplina disciplina) {
        if(disciplina == null){
            throw new BusinessException(DISCIPLINA_NULL);
        } else {
            return disciplinaDao.save(disciplina);
        }
    }

    @Override
    public Disciplina updateDisciplina(Disciplina disciplina) {
        if(disciplina == null){
            throw new BusinessException(DISCIPLINA_NULL);
        } else if(disciplinaDao.existsById(disciplina.getId()) == false) {
            throw new BusinessException(DISCIPLINA_NAO_EXISTE);
        } else {
            return disciplinaDao.save(disciplina);
        }    
    }

    @Override
    public void deleteDisciplina(Disciplina disciplina) {
        if(disciplina == null){
            throw new BusinessException(DISCIPLINA_NULL);
        }else if(this.disciplinaDao.existsById(disciplina.getId()) == true) {
            this.disciplinaDao.delete(disciplina);
            return;
        }
            throw new BusinessException(DISCIPLINA_NAO_EXISTE);    
}

    @Override
    public List<Disciplina> getAllDisciplina() {
        return this.disciplinaDao.findAll();    
    }
    
    @Override
    public List<Disciplina> findByNome(String nome) {
        if(nome == null) {
            throw new BusinessException("nome null");
        } else if(nome.isEmpty()) {
            throw new BusinessException("nome vazio");
        } else {
            return disciplinaDao.findByNome(nome);
        }
    }
    
}
