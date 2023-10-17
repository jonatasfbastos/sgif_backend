package br.com.ifba.entity.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ifba.entity.curso.dao.IDaoCurso;
import br.com.ifba.entity.curso.model.Curso;
import br.com.ifba.infrastructure.exception.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService {
    
    //-_-_-_-_-_-_-_-_-_- CONSTANTES -_-_-_-_-_-_-_-_-_-
    
    //mensagem de erro caso o Curso seja nulo;
    public final static String CURSO_NULL = "Dados do Curso nao preenchidos";
    
    //mensagem de erro caso o Curso exista no banco de dados;
    public final static String CURSO_EXISTE = "Curso ja existente no Banco de dados";
    
    //mensagem de erro caso o Curso não exista no banco de dados;
    public final static String CURSO_NAO_EXISTE = "Curso nao existente no Banco de dados";
    
    //mensagem de erro caso o Curso seja inválido;
    public final static String CURSO_INVALIDO = "As informaacoes do Curso nao sao validas";
    
    // Mensagem de erro se o Curso possuir matriz curricular
    public final static String CURSO_POSSUI_MATRIZ_CURRICULAR = "Curso possui matriz curricular";
    
    //-_-_-_-_-_-_-_-_-_- OBJETO -_-_-_-_-_-_-_-_-_-
    
    @Autowired
     private IDaoCurso cursoDao;
     
    //-_-_-_-_-_-_-_-_-_- MÉTODOS -_-_-_-_-_-_-_-_-_-
    
    @Override
    public Curso saveCurso(Curso curso) {
        if(curso == null){
            throw new BusinessException(CURSO_NULL);
        } else if(cursoDao.existsById(curso.getId()) == true){
            throw new BusinessException(CURSO_EXISTE);
        } else {
            return cursoDao.save(curso);
        }
    }

    @Override
    public Curso updateCurso(Curso curso) {
        if(curso == null){
            throw new BusinessException(CURSO_NULL);
        } else if(cursoDao.existsById(curso.getId()) == false) {
            throw new BusinessException(CURSO_NAO_EXISTE);
        } else {
            return cursoDao.save(curso);
        }    
    }

    @Override
    public void deleteCurso(Curso curso) {
        if(curso == null){
            throw new BusinessException(CURSO_NULL);
        }else if(this.cursoDao.existsById(curso.getId()) == true) {
            if (curso.getMatrizCurricular() == null){
                throw new BusinessException(CURSO_POSSUI_MATRIZ_CURRICULAR);
            }
            this.cursoDao.delete(curso);
            return;
        }
            throw new BusinessException(CURSO_NAO_EXISTE);    
            
}

    @Override
    public List<Curso> getAllCurso() {
        return this.cursoDao.findAll();    
    }

    @Override
    public Curso findById(Long id) {
        if(id == null) {
            throw new BusinessException("id null");
        } else if(id <= 0) {
            throw new BusinessException("id invalido");
        } else {
            return cursoDao.findById(id).orElse(null);
        }
    }
}

    