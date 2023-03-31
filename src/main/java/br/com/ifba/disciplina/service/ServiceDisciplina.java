package br.com.ifba.disciplina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.disciplina.dao.IDaoDisciplina;
import br.com.ifba.disciplina.model.Disciplina;
import br.com.ifba.infrastructure.exception.BusinessException;

@Service
public class ServiceDisciplina implements IServiceDisciplina{
    //mensagem de erro se o Usuario for null;
    public final static String USUARIO_NULL = "Dados do Usuario nÃ£o preenchidos";
    
    //mensagem de erro se o Usuario jÃ¡ existir;
    public final static String USUARIO_EXISTE = "Usuario ja existente no Banco de dados";
    
    //mensagem de erro se o Usuario nÃ£o existir no banco;
    public final static String USUARIO_NAO_EXISTE = "Usuario nao existente no Banco de dados";
    
    //mensagem de erro se o Usuario for invÃ¡lido;
    public final static String USUARIO_INVALIDO = "As informaÃ§oes do Usuario nao sao validas";
    
    @Autowired
     private IDaoDisciplina disciplinaDao;
     
     @Override
    public Disciplina saveDisciplina(Disciplina disciplina) {
        if(disciplina == null){
            throw new BusinessException(USUARIO_NULL);
        } else if(disciplinaDao.existsById(disciplina.getId()) == true){
            throw new BusinessException(USUARIO_EXISTE);
        } else {
            return disciplinaDao.save(disciplina);
        }
    }

    @Override
    public Disciplina updateDisciplina(Disciplina disciplina) {
        if(disciplina == null){
            throw new BusinessException(USUARIO_NULL);
        } else if(disciplinaDao.existsById(disciplina.getId()) == false) {
            throw new BusinessException(USUARIO_NAO_EXISTE);
        } else {
            return disciplinaDao.save(disciplina);
        }    
    }

    @Override
    public void deleteDisciplina(Disciplina disciplina) {
        if(disciplina == null){
            throw new BusinessException(USUARIO_NULL);
        }else if(this.disciplinaDao.existsById(disciplina.getId()) == true) {
            this.disciplinaDao.delete(disciplina);
            return;
        }
            throw new BusinessException(USUARIO_NAO_EXISTE);    
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
