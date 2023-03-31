package br.com.ifba.matrizCurricular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.matrizCurricular.dao.IDaoMatrizCurricular;
import br.com.ifba.matrizCurricular.model.MatrizCurricular;

@Service
public class ServiceMatrizCurricular implements IServiceMatrizCurricular{
    
    // Mensagem de erro se a Matriz Curricular for null.
    public final static String MATRIZ_CURRICULAR_NULL = "Dados da Matriz Curricular nao preenchidos";
    
    // Mensagem de erro se a Matriz Curricular jÃ¡ existe.
    public final static String MATRIZ_CURRICULAR_EXISTE = "Matriz Curricular ja existente no Banco de dados";
    
    // Mensagem de erro se a Matriz Curricular nÃ£o existir no banco.
    public final static String MATRIZ_CURRICULAR_NAO_EXISTE = "Matriz Curricular nao existente no Banco de dados";
    
    // Mensagem de erro se a Matriz Curricular for invÃ¡lida.
    public final static String MATRIZ_CURRICULAR_INVALIDO = "As informaÃ§oes da Matriz Curricular nao sao validas";
    
     // Mensagem de erro caso o nome esteja vazio.
    private final static String NOME_VAZIO = "O Campo Nome esta vazio";
    
    // Mensagem de erro caso o nome seja null.
    private final static String NOME_NULL = "Dados do nome nao preenchidos";
    
     //================= OBJETO =================================================
    @Autowired
    private IDaoMatrizCurricular matrizCurricularDao;

     //================= MÃ‰TODOS ================================================
    @Override
    public MatrizCurricular saveMatrizCurricular(MatrizCurricular matrizCurricular) {
       if(matrizCurricular == null) {
            throw new BusinessException(MATRIZ_CURRICULAR_NULL);
        } 
       if(matrizCurricularDao.existsByNome(matrizCurricular.getNome()) == true) {
            throw new BusinessException(MATRIZ_CURRICULAR_EXISTE);
        }
       return matrizCurricularDao.save(matrizCurricular);
    }

    @Override
    public MatrizCurricular updateMatrizCurricular(MatrizCurricular matrizCurricular) {
        if(matrizCurricular == null) {
            throw new BusinessException(MATRIZ_CURRICULAR_NULL);
        }
        if(matrizCurricularDao.existsById(matrizCurricular.getId()) == false) {
            throw new BusinessException(MATRIZ_CURRICULAR_NAO_EXISTE);
        }
        return matrizCurricularDao.save(matrizCurricular);
    }

    @Override
    public void deleteMatrizCurricular(MatrizCurricular matrizCurricular) {
        if(matrizCurricular == null) {
            throw new BusinessException(MATRIZ_CURRICULAR_NULL);
        }
        if(matrizCurricularDao.existsById(matrizCurricular.getId()) == false) {
            throw new BusinessException(MATRIZ_CURRICULAR_NAO_EXISTE);
        }
        matrizCurricularDao.delete(matrizCurricular);
    }

    @Override
    public List<MatrizCurricular> getAllMatrizCurricular() {
        return this.matrizCurricularDao.findAll();
    }
    
    @Override
    public List<MatrizCurricular> findByNome(String nome) {
        if(nome == null) {
            throw new BusinessException(NOME_NULL);
        }
        if(nome.isEmpty()) {
            throw new BusinessException(NOME_VAZIO);
        }
        return matrizCurricularDao.findByNome(nome);
    }
    
     @Override
     public MatrizCurricular findById(Long id) {
          return matrizCurricularDao.getReferenceById(id);
     }
}
