package br.com.ifba.sgif.api.entity.turma.service;

import java.util.List;
import java.util.Optional;

import br.com.ifba.sgif.api.entity.turma.dao.ITurmaDao;
import br.com.ifba.sgif.api.entity.turma.dto.TurmaResponseDto;
import br.com.ifba.sgif.api.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.ifba.sgif.api.infrastructure.exception.BusinessException;
import br.com.ifba.sgif.api.entity.turma.model.Turma;
import org.springframework.stereotype.Service;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Service
public class TurmaService implements ITurmaService {

    // =========================================================== //
    // =============== [       ATRIBUTOS        ] ================ //
    // =========================================================== //
    @Autowired
    private ITurmaDao turmaDao;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * Lista todas as turmas presentes na base de dados.
     * @return uma lista com todas as turmas da base de dados, ou nulo, caso não exista nenhuma.
     */
    @Override
    public List<TurmaResponseDto> listarTurmas() {

        return this.objectMapperUtil.mapAll(
                this.turmaDao.findAll(),
                TurmaResponseDto.class
        );

    }

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * @param turma A turma que será salva na base de dados.
     * @return um objeto DTO com os dados da turma salva na base de dados,
     * caso a operação ocorra com sucesso.
     */
    @Override
    public TurmaResponseDto salvarTurma(Turma turma) {

        return Optional.of(turma)
                .filter(t -> this.turmaDao.existsByCodigoTurma(turma.getCodigoTurma()))
                .map(t -> this.objectMapperUtil.map(this.turmaDao.save(t), TurmaResponseDto.class))
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.ATTRIBUTE_VALUE_ALREADY_EXISTS.getMensagemValorJaExiste("codigoTurma"))
                );
    }

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * @param turma A turma que terá os seus dados atualizados.
     * @return um DTO com os dados atualizados da turma.
     */
    @Override
    public TurmaResponseDto atualizarTurma(Turma turma) {

        return this.turmaDao.findById(turma.getId())
                .map(t -> this.objectMapperUtil.map(this.turmaDao.save(t), TurmaResponseDto.class))
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );

    }

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * @param id O ID da turma que será deletado da base de dados.
     * @return um DTO com os dados da turma deletada da base de dados.
     */
    @Override
    public TurmaResponseDto deletarTurmaPorId(Long id) {

        return this.turmaDao.findById(id)
                .map(t -> {
                    this.turmaDao.delete(t);
                    return this.objectMapperUtil.map(t, TurmaResponseDto.class);
                })
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );

    }
}
