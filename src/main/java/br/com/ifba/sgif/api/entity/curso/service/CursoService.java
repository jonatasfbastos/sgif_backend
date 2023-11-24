package br.com.ifba.sgif.api.entity.curso.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.curso.dto.CursoResponseDto;
import br.com.ifba.sgif.api.entity.curso.dao.IDaoCurso;
import br.com.ifba.sgif.api.entity.curso.model.Curso;
import br.com.ifba.sgif.api.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.sgif.api.infrastructure.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Unknown
 * Editado por Giovane Neves
 * Desde V1.0.1
 */
@Service
public class CursoService implements ICursoService {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoCurso cursoDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     * <p>
     * Lista todos os cursos cadastrados na base de dados.
     * @return uma lista com todos os cursos da base de dados.
     */
    @Override
    public List<CursoResponseDto> listarCursos() {

        return objectMapperUtil.mapAll(
                this.cursoDao.findAll(),
                CursoResponseDto.class
        );
    }

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     * <p>
     * Busca o curso cadastrado na base de dados atrelado ao ID
     * passado por parâmetro.
     * @param id O ID do curso a ser buscado.
     * @return o curso atrelado ao ID passado por parâmetro.
     */
    @Override
    public CursoResponseDto encontrarCursoPorId(UUID id) {


        return objectMapperUtil.map(
                this.cursoDao.findById(id)
                        .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())),
                CursoResponseDto.class
        );

    }

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     * <p>
     * Cadastra um curso na base de dados.
     * @param curso O curso a ser cadastrado.
     * @return dados básicos do curso cadastrado.
     */
    @Override
    public CursoResponseDto salvarCurso(Curso curso) {


        // >>>>> TODO: Analisar regra de negócios para salvar cursos.

        if (cursoDao.existsByCodigoCurso(curso.getCodigoCurso()))
            throw new BusinessException(
                    BusinessExceptionMessage.ATTRIBUTE_VALUE_ALREADY_EXISTS
                            .getMensagemValorJaExiste("código curso")
            );


        return objectMapperUtil.map(
                curso,
                CursoResponseDto.class
        );

    }

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     * <p>
     * Atualiza um curso existente na base de dados.
     * @param curso O curso a ser atualizado.
     * @return dados básicos do curso atualizado.
     */
    @Override
    public CursoResponseDto atualizarCurso(Curso curso) {

        if (!cursoDao.existsById(curso.getId()))
            throw new BusinessException(
                    BusinessExceptionMessage.NOT_FOUND.getMensagem()
            );

        return objectMapperUtil.map(
                this.cursoDao.save(curso),
                CursoResponseDto.class
        );


    }

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     * <p>
     * Deleta o formulário atrelado ao ID passado por parâmetro.
     * @param id O ID do formulário a ser deletado.
     * @return dados básicos do formulário deletado.
     */
    @Override
    public CursoResponseDto deletarCursoPorId(UUID id) {

        // TODO: Analisar regra de negócio atual.

        if (!this.cursoDao.existsById(id))
            throw new BusinessException(
                    BusinessExceptionMessage.NOT_FOUND.getMensagem()
            );


        this.cursoDao.deleteById(id);

        return objectMapperUtil.map(
                this.cursoDao.findById(id),
                CursoResponseDto.class
        );

    }

}

    