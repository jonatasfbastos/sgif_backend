package br.com.ifba.entity.matrizcurricular.service;

import br.com.ifba.entity.etapacurso.dao.IEtapaCursoDao;
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
 * Editado por Andesson Reis
 */
@Service
public class ServiceMatrizCurricular implements IServiceMatrizCurricular {
    
    @Autowired
    private IDaoMatrizCurricular matrizCurricularDao;

    @Autowired
    private IEtapaCursoDao etapaCursoDao;
    
    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Salva uma Matriz Curricular na base de dados e retorna um objeto DTO com os dados resumidos da Matriz Curricular salva.
     *
     * @param matrizCurricular - A Matriz Curricular que será salva na base de dados.
     * @return um objeto DTO com os dados resumidos da Matriz Curricular salva.
     */
    @Override
    public MatrizCurricularResponseDto saveMatrizCurricular(MatrizCurricular matrizCurricular) {
        return objectMapperUtil.map(
                matrizCurricularDao.save(matrizCurricular),
                MatrizCurricularResponseDto.class);
    }

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Atualiza uma Matriz Curricular na base de dados e retorna um objeto DTO com os dados resumidos da Matriz Curricular atualizada.
     *
     * @param matrizCurricular - A Matriz Curricular que será atualizada na base de dados.
     * @return um objeto DTO com os dados resumidos da Matriz Curricular atualizada.
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
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Deleta uma Matriz Curricular com base no ID.
     *
     * @param id - O ID da Matriz Curricular a ser deletada.
     * @return um objeto DTO com os dados da Matriz Curricular deletada.
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

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Obtém uma lista de todas as Matrizes Curriculares como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as Matrizes Curriculares.
     */
    @Override
    public List<MatrizCurricularResponseDto> getAllMatrizCurricular() {
        return objectMapperUtil.mapAll(
                this.matrizCurricularDao.findAll(),
                MatrizCurricularResponseDto.class);
    }
}
