package br.com.ifba.professor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.professor.dao.IDaoProfessor;
import br.com.ifba.professor.model.Professor;

@Service
public class ServiceProfessor implements IServiceProfessor{
    // Mensagem de erro se o Professor for null.
    public final static String PROFESSOR_NULL = "Dados do Professor nao preenchidos";
    // Mensagem de erro se o Professor jÃ¡ existir.
    public final static String PROFESSOR_EXISTE = "Professor ja existente no Banco de dados";
    // Mensagem de erro se o Professor nÃ£o existir no banco.
    public final static String PROFESSOR_NAO_EXISTE = "Professor nao existente no Banco de dados";
    // Mensagem de erro se o Professor for invÃ¡lido.
    public final static String PROFESSOR_INVALIDO = "As informaÃ§oes do Professor nao sao validas";
     // Mensagem de erro caso o nome esteja vazio.
    private final static String NOME_VAZIO = "O Campo Nome esta vazio";
    // Mensagem de erro caso o nome seja null.
    private final static String NOME_NULL = "Dados do nome nao preenchidos";
    
     //================= OBJETO =================================================
    @Autowired
    private IDaoProfessor professorDao;
    
     //================= MÃ‰TODOS ================================================
    @Override
    public Professor saveProfessor(Professor professor) {
       
       if(professor == null) {
            throw new BusinessException(PROFESSOR_NULL);
        }
       if(professorDao.existsBySiape(professor.getSiape())){
           throw new BusinessException(PROFESSOR_EXISTE);
       }
       return professorDao.save(professor);
    }

    @Override
    public Professor updateProfessor(Professor professor) {
        if(professor == null) {
            throw new BusinessException(PROFESSOR_NULL);
        } 
        if(professorDao.existsById(professor.getId()) == false) {
            throw new BusinessException(PROFESSOR_NAO_EXISTE);
        }
        return professorDao.save(professor);
    }

    @Override
    public void deleteProfessor(Professor professor) {
        if(professor == null) {
            throw new BusinessException(PROFESSOR_NULL);
        } 
        if(professorDao.existsById(professor.getId()) == false) {
            throw new BusinessException(PROFESSOR_NAO_EXISTE);
        }
        professorDao.delete(professor);
    }

    @Override
    public List<Professor> getAllprofessor() {
        return this.professorDao.findAll();
    }
    
    @Override
    public List<Professor> findByNome(String nome) {
        if(nome == null) {
            throw new BusinessException(NOME_NULL);
        } 
        if(nome.isEmpty()) {
            throw new BusinessException(NOME_VAZIO);
        }
        return professorDao.findByNome(nome); 
    }
    
     @Override
     public Professor findById(Long id) {
          return professorDao.getReferenceById(id);
     }
}
