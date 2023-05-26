package br.com.ifba.disciplina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.disciplina.dao.IDaoDisciplina;
import br.com.ifba.disciplina.model.Disciplina;
import br.com.ifba.infrastructure.exception.BusinessException;

@Service
public class ServiceDisciplina implements IServiceDisciplina{
    // Mensagem de erro se o Disciplina for null
    public final static String DISCIPLINA_NULL = "Dados do Disciplina não preenchidos";

    // Mensagem de erro se o Disciplina já existir
    public final static String DISCIPLINA_EXISTE = "Disciplina já existente no Banco de dados";

    // Mensagem de erro se o Disciplina não existir no banco
    public final static String DISCIPLINA_NAO_EXISTE = "Disciplina não existente no Banco de dados";

    // Mensagem de erro se o Disciplina for inválido
    public final static String DISCIPLINA_INVALIDO = "As informações do Disciplina não são válidas";

    // Mensagem de erro se o Disciplina tiver etapa curso
    public final static String DISCIPLINA_POSSUI_ETAPA_CURSO = "Disciplina possui etapa curso";

    
    @Autowired
     private IDaoDisciplina disciplinaDao;
     
     @Override
    public Disciplina saveDisciplina(Disciplina disciplina) {
        if(disciplina == null){
            throw new BusinessException(DISCIPLINA_NULL);
        } 
        if(disciplinaDao.existsByDescricao(disciplina.getDescricao())){
            throw new BusinessException(DISCIPLINA_EXISTE);
        }
        else {
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
            if (disciplina.getEtapaCurso() == null){
                throw new BusinessException(DISCIPLINA_POSSUI_ETAPA_CURSO);
            }
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

    @Override
    public Disciplina findById(Long id) {
        if(id == null) {
            throw new BusinessException("id null");
        } else if(id <= 0) {
            throw new BusinessException("id invalido");
        } else {
            return disciplinaDao.findById(id).orElse(null);
        }
    }
    
}
