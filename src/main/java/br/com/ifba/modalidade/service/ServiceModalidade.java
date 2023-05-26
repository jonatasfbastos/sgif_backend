package br.com.ifba.modalidade.service;

import java.util.List;
import br.com.ifba.curso.dao.IDaoCurso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.modalidade.dao.IDaoModalidade;
import br.com.ifba.modalidade.model.Modalidade;

@Service
public class ServiceModalidade implements IServiceModalidade{
    //-_-_-_-_-_-_-_-_-_- CONSTANTES -_-_-_-_-_-_-_-_-_-
    
    //mensagem de erro caso a Modalidade seja nula;
    public final static String MODALIDADE_NULL = "Dados da Modalidade nao preenchidos";
    
    //mensagem de erro caso a Modalidade ja exista no banco de dados;
    public final static String MODALIDADE_EXISTE = "Modalidade ja existente no Banco de dados";
    
    //mensagem de erro caso a Modalidade nao exista no banco de dados;
    public final static String MODALIDADE_NAO_EXISTE = "Modalidade nao existente no Banco de dados";
    
    //mensagem de erro caso a Modalidade seja invalida;
    public final static String MODALIDADE_INVALIDO = "As informaÃ§oes da Modalidade nao sao validas";

    //mensagem de erro caso ja exista um ou mais cursos atrelados a essa modalidade
    public final static String CURSO_EXISTE = "Nao e possivel excluir modalidade com curso atrelado a ela";
    
    //-_-_-_-_-_-_-_-_-_- OBJETO -_-_-_-_-_-_-_-_-_-
    
    @Autowired
    private IDaoModalidade modalidadeDao;
    @Autowired
    private IDaoCurso cursoDao;
     
    //-_-_-_-_-_-_-_-_-_- METODOS -_-_-_-_-_-_-_-_-_-
    
    @Override
    public Modalidade saveModalidade(Modalidade modalidade) {
        if(modalidade == null){
            throw new BusinessException(MODALIDADE_NULL);
        } else {
            return modalidadeDao.save(modalidade);
        }
    }

    @Override
    public Modalidade updateModalidade(Modalidade modalidade) {
        if(modalidade == null){
            throw new BusinessException(MODALIDADE_NULL);
        } else if(modalidadeDao.existsById(modalidade.getId()) == false) {
            throw new BusinessException(MODALIDADE_NAO_EXISTE);
        } else {
            return modalidadeDao.save(modalidade);
        }    
    }

    @Override
    public void deleteModalidade(Modalidade modalidade) {
        if(modalidade == null){
            throw new BusinessException(MODALIDADE_NULL);
        }else if(this.modalidadeDao.existsById(modalidade.getId()) == true) {
            this.modalidadeDao.delete(modalidade);
            return;
        }else if(modalidadeDao.getReferenceById(modalidade.getId()).getCursos().isEmpty() == false){
            throw new BusinessException(CURSO_EXISTE);
        }
            throw new BusinessException(MODALIDADE_NAO_EXISTE);    
}

    @Override
    public List<Modalidade> getAllModalidade() {
        return this.modalidadeDao.findAll();    
    }
    
    @Override
    public Modalidade findById(Long id) {
        return modalidadeDao.getReferenceById(id);
    }  

    @Override
    public List<Modalidade> findByNome(String nome) {
        if(nome == null) {
            throw new BusinessException("Dados do nome nao preenchidos");
        } else if(nome.isEmpty()) {
            throw new BusinessException("O Campo Nome esta vazio");
        } else {
            return modalidadeDao.findByNome(nome);
        }
    }
}