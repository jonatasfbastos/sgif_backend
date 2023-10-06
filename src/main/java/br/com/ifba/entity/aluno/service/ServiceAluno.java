package br.com.ifba.entity.aluno.service;

import java.util.List;

import br.com.ifba.entity.aluno.dao.IDaoAluno;
import br.com.ifba.entity.aluno.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;

@Service
public class ServiceAluno implements IServiceAluno{
    
    // Mensagem de erro se o Aluno for null.
    public final static String ALUNO_NULL = "Dados do Aluno nao preenchidos";
    // Mensagem de erro se o Aluno jÃ¡ existir.
    public final static String ALUNO_EXISTE = "Aluno ja existente no Banco de dados";
    // Mensagem de erro se o Aluno nÃ£o existir no banco.
    public final static String ALUNO_NAO_EXISTE = "Aluno nao existente no Banco de dados";
    // Mensagem de erro se o Aluno for invÃ¡lido.
    public final static String ALUNO_INVALIDO = "As informaÃ§oes do Aluno nao sao validas";
     // Mensagem de erro caso o nome esteja vazio.
    
     //================= OBJETO =================================================
    @Autowired
    private IDaoAluno alunoDao;

     //================= MÃ‰TODOS ================================================
    @Override
    public Aluno saveAluno(Aluno aluno) {
       if(aluno == null) {
            throw new BusinessException(ALUNO_NULL);
       } else{
            return alunoDao.save(aluno);
       }
    }

    @Override
    public Aluno updateAluno(Aluno aluno) {
        if(aluno == null) {
            throw new BusinessException(ALUNO_NULL);
        } 
        if(alunoDao.existsById(aluno.getId()) == false) {
            throw new BusinessException(ALUNO_NAO_EXISTE);
        }
        return alunoDao.save(aluno);
    }

    @Override
    public void deleteAluno(Aluno aluno) {
        if(aluno == null) {
            throw new BusinessException(ALUNO_NULL);
        } 
        if(alunoDao.existsById(aluno.getId()) == false) {
            throw new BusinessException(ALUNO_NAO_EXISTE);
        }
        alunoDao.delete(aluno);
    }

    @Override
    public List<Aluno> getAllaluno() {
        return this.alunoDao.findAll();
    }

    @Override
    public List<Aluno> findByStatusAlunoId(Long id) {
        return alunoDao.findByStatusAlunoId(id);
    }
}
