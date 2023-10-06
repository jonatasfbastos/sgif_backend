package br.com.ifba.entity.turma.service;

import java.util.List;

import br.com.ifba.entity.turma.dao.IDaoTurma;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.entity.turma.model.Turma;
import org.springframework.stereotype.Service;

@Service
public class ServiceTurma implements IServiceTurma{
    
    private final static String TURMA_NULL = "Dados da Turma nao preenchidos";
    // Mensagem de erro se o Turma jÃ¡ existir.
    public final static String TURMA_EXISTE = "Turma ja existente no Banco de dados";
    // Mensagem de erro se a Turma nÃ£o existir no banco.
    private final static String TURMA_NAO_EXISTE = "Turma nao existente no Banco de dados";
    // Mensagem de erro caso o nome esteja vazio.
    public final static String NOME_VAZIO = "O Campo Nome esta vazio";
    // Mensagem de erro caso o nome seja null.
        
     //================= OBJETO =================================================
    @Autowired
    private IDaoTurma turmaDao;

     //================= MÃ‰TODOS ================================================
    @Override
    public Turma saveTurma(Turma turma) {
       if(turma == null){
            throw new BusinessException(TURMA_NULL);
        } else{
            return this.turmaDao.save(turma);
        }
    }

    @Override
    public Turma updateTurma(Turma turma) {
        if(turma == null){
            throw new BusinessException(TURMA_NULL);
        } 
        if(turmaDao.existsById(turma.getId()) == false) {
            throw new BusinessException(TURMA_NAO_EXISTE);
        }
        return this.turmaDao.save(turma);        
    }

    @Override
    public void deleteTurma(Turma turma) {
        if(turma == null){
            throw new BusinessException(TURMA_NULL);
        } 
        if(turmaDao.existsById(turma.getId()) == false) {
            throw new BusinessException(TURMA_NAO_EXISTE);
        }
        this.turmaDao.delete(turma);
    }

    @Override
    public List<Turma> getAllTurma() {
        return this.turmaDao.findAll();
    }
}