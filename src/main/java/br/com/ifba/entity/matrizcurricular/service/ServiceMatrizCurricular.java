package br.com.ifba.entity.matrizcurricular.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.entity.matrizcurricular.dao.IDaoMatrizCurricular;
import br.com.ifba.entity.matrizcurricular.dto.MatrizCurricularResponseDto;
import br.com.ifba.entity.matrizcurricular.model.MatrizCurricular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
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

    /**
     * Atualiza uma Matriz Curricular na base de dados e retorna um objeto DTO com os dados resumidos da Matriz Curricular atualizada.
     *
     * @param matrizCurricular - A Matriz Curricular que será atualizada na base de dados.
     * @return um objeto DTO com os dados resumidos da Matriz Curricular atualizada.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public MatrizCurricularResponseDto updateMatrizCurricular(MatrizCurricular matrizCurricular) {
        matrizCurricularDao.findById(matrizCurricular.getId())
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        return objectMapperUtil.map(
                matrizCurricularDao.save(matrizCurricular),
                MatrizCurricularResponseDto.class);
    }

    /**
     * Deleta uma Matriz Curricular com base no ID.
     *
     * @param id - O ID da Matriz Curricular a ser deletada.
     * @return um objeto DTO com os dados da Matriz Curricular deletada.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public MatrizCurricularResponseDto deleteMatrizCurricular(UUID id) {
        return this.matrizCurricularDao.findById(id)
                .map(matrizCurricular -> {
                    matrizCurricularDao.delete(matrizCurricular);
                    return objectMapperUtil.map(matrizCurricular, MatrizCurricularResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
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
