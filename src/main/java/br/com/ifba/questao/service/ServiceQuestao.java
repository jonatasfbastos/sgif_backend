package br.com.ifba.questao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.questao.dao.IDaoQuestao;
import br.com.ifba.questao.model.Questao;

@Service
public class ServiceQuestao implements IServiceQuestao{
    
    //-_-_-_-_-_-_-_-_-_- CONSTANTES -_-_-_-_-_-_-_-_-_-
    
    //mensagem de erro caso a Questao seja nula;
    public final static String QUESTAO_NULL = "Dados da Questao nao preenchidos";
    
    //mensagem de erro caso a Questao já exista no banco de dados;
    public final static String QUESTAO_EXISTE = "Questao ja existente no Banco de dados";
    
    //mensagem de erro caso a Questao não exista no banco de dados;
    public final static String QUESTAO_NAO_EXISTE = "Questao nao existente no Banco de dados";
    
    //mensagem de erro caso a Questao seja inválida;
    public final static String QUESTAO_INVALIDO = "As informaçoes da Questao nao sao validas";
    // mensagem de erro caso a Questao seja vazia;
    private final static String QUESTAO_VAZIO = "O Enunciado esta vazio";
    
    //-_-_-_-_-_-_-_-_-_- OBJETO -_-_-_-_-_-_-_-_-_-
    
    @Autowired
     private IDaoQuestao questaoDao;
     
    //-_-_-_-_-_-_-_-_-_- MÉTODOS -_-_-_-_-_-_-_-_-_-

    @Override
    public Questao saveQuestao(Questao questao) {
        if(questao == null) {
            throw new BusinessException(QUESTAO_NULL);
        }
       if(questaoDao.existsByEnunciado(questao.getEnunciado()) == true) {
            throw new BusinessException(QUESTAO_EXISTE);
        }
       return questaoDao.save(questao);}

    @Override
    public Questao updateQuestao(Questao questao) {
        if(questao == null) {
            throw new BusinessException(QUESTAO_NULL);
        } 
        if(questaoDao.existsById(questao.getId()) == false) {
            throw new BusinessException(QUESTAO_NAO_EXISTE);
        }
        return questaoDao.save(questao);
    }

    @Override
    public void deleteQuestao(Questao questao) {
       if(questao == null) {
            throw new BusinessException(QUESTAO_NULL);
        } 
        if(questaoDao.existsById(questao.getId()) == false) {
            throw new BusinessException(QUESTAO_NAO_EXISTE);
        }
        questaoDao.delete(questao);
    }

     @Override
    public List<Questao> getAllQuestao() {
        return this.questaoDao.findAll();
    }
    
    @Override
    public List<Questao> findByEnunciado(String enunciado) {
        if(enunciado == null) {
            throw new BusinessException(QUESTAO_NULL);
        } 
        if(enunciado.isEmpty()) {
            throw new BusinessException(QUESTAO_VAZIO);
        }
        return questaoDao.findByEnunciado(enunciado); 
    }
    
     @Override
     public Questao findById(Long id) {
          return questaoDao.getReferenceById(id);
     }

}
