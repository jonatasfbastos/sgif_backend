package br.com.ifba.sgif.api.entity.disciplina.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.ifba.sgif.api.entity.disciplina.dao.IDisciplinaDao;
import br.com.ifba.sgif.api.entity.disciplina.dto.DisciplinaResponseDto;
import br.com.ifba.sgif.api.entity.disciplina.model.Disciplina;
import br.com.ifba.sgif.api.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.sgif.api.infrastructure.exception.BusinessException;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Service
public class DisciplinaService implements IDisciplinaService {

    // =========================================================== //
    // =============== [       ATRIBUTOS        ] ================ //
    // =========================================================== //

    @Autowired
    private IDisciplinaDao _disciplinaDao;

    @Autowired
    private ObjectMapperUtil _objectMapperUtil;


    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    /**
     * Lista todas as disciplinas cadastradas na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return uma lista de DTO com dados de todas as disciplinas da base de dados.
     */
    @Override
    public List<DisciplinaResponseDto> listarDisciplinas() {

        return this._objectMapperUtil.mapAll(
                this._disciplinaDao.findAll(),
                DisciplinaResponseDto.class
        );

    }

    /**
     * Lista todas as disciplinas cadastradas na base de dados
     * que possuam o professor passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param professor O nome do professor.
     * @return uma lista de DTO com dados de todas as disciplinas da base de dados.
     */
    @Override
    public List<DisciplinaResponseDto> listarDisciplinas(final String professor) {

        return this._disciplinaDao.findDisciplinaByProfessorNome(professor)
                .stream()
                .map(d -> this._objectMapperUtil.map(d, DisciplinaResponseDto.class))
                .collect(Collectors.toList());

    }

    /**
     * Busca uma disciplina na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da disciplina a ser buscada.
     * @return DTO com dados da disciplina atrelada ao ID passado por parâmetro.
     */
    @Override
    public DisciplinaResponseDto encontrarDisciplinaPorId(final Long id) {

        return this._disciplinaDao.findById(id)
                .map(d -> this._objectMapperUtil.map(d, DisciplinaResponseDto.class))
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );

    }

    /**
     * Busca disciplinas na base de dados com base no nome
     * passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param nome O nome das disciplinas a serem buscadas.
     * @return Lista de DTO com dados das disciplinas que possuem o nome
     * passado por parâmetro.
     */
    @Override
    public List<DisciplinaResponseDto> encontrarDisciplinaPorNome(final String nome) {

        return this._disciplinaDao.findByNome(nome)
                .stream()
                .map(d -> this._objectMapperUtil.map(d, DisciplinaResponseDto.class))
                .collect(Collectors.toList());
    }

    /**
     * Salva uma disciplina na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param disciplina A disciplina a ser salva na base de dados.
     * @return DTO com dados da disciplina salva.
     */
    @Override
    public DisciplinaResponseDto salvarDisciplina(final Disciplina disciplina) {

        // TODO: Adicionar verificação de código, para evitar cadastro de disciplinas com código repetido

        return this._objectMapperUtil.map(
                this._disciplinaDao.save(disciplina),
                DisciplinaResponseDto.class
        );

    }

    /**
     * Atualiza uma disciplina existente na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param disciplina A disciplina a ser atualizada.
     * @return DTO com dados da disciplina atualizada.
     */
    @Override
    public DisciplinaResponseDto atualizarDisciplina(final Disciplina disciplina) {

        // TODO: Adicionar verificação de código, para evitar cadastro de disciplinas com código repetido

        return this._disciplinaDao.findById(disciplina.getId())
                .map(d -> this._objectMapperUtil.map(d, DisciplinaResponseDto.class))
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );
    }

    /**
     * Deleta uma disciplina na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da disciplina a ser deletada.
     * @return DTO com dados da disciplina deletada.
     */
    @Override
    public DisciplinaResponseDto deletarDisciplinaPorId(final Long id) {

        return this._disciplinaDao.findById(id)
                .map(d -> {
                    this._disciplinaDao.delete(d);
                    return this._objectMapperUtil.map(d, DisciplinaResponseDto.class);
                })
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );


    }

}
