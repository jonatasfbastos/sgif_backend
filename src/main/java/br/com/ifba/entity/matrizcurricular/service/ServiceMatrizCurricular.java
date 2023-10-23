package br.com.ifba.entity.matrizcurricular.service;

import java.util.List;

import br.com.ifba.entity.matrizcurricular.dao.IDaoMatrizCurricular;
import br.com.ifba.entity.matrizcurricular.dto.MatrizCurricularResponseDto;
import br.com.ifba.entity.matrizcurricular.model.MatrizCurricular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * Service que fornece operações relacionadas a Matriz Curricular.
 *
 * @author unknown
 * @since V1.0.1
 * @Editado por Andesson Reis
 */

@Service
public class ServiceMatrizCurricular implements IServiceMatrizCurricular{
    
  
    @Autowired
    private IDaoMatrizCurricular matrizCurricularDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    /**
     * Salva uma Matriz Curricular na base de dados e retorna um objeto DTO com os dados resumidos da Matriz Curricular salva.
     *
     * @param matrizCurricular - A Matriz Curricular que será salva na base de dados.
     * @return um objeto DTO com os dados resumidos da Matriz Curricular salva.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public MatrizCurricularResponseDto saveMatrizCurricular(MatrizCurricular matrizCurricular) {
        return objectMapperUtil.map(
                matrizCurricularDao.save(matrizCurricular),
                MatrizCurricularResponseDto.class);
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
    /*public void deleteMatrizCurricular(Long id) {
        if (matrizCurricularDao.existsById(id) == false) {
            throw new BusinessException(MATRIZ_CURRICULAR_NAO_EXISTE);
        }
        matrizCurricularDao.delete(matrizCurricularDao.getReferenceById(id)); 
    }*/
    public void deleteMatrizCurricular(MatrizCurricular matrizCurricular) {
        if(matrizCurricular == null) {
            throw new BusinessException(MATRIZ_CURRICULAR_NULL);
        }
        if(matrizCurricularDao.existsById(matrizCurricular.getId()) == false) {
            throw new BusinessException(MATRIZ_CURRICULAR_NAO_EXISTE);
        }
        if(matrizCurricularDao.getReferenceById(matrizCurricular.getId()).getEtapacurso().isEmpty() == false) {
            throw new BusinessException(ETAPA_CURSO_EXISTE);
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
