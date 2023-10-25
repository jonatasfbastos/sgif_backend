package br.com.ifba.entity.disciplina.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.ifba.entity.disciplina.dao.IDisciplinaDao;
import br.com.ifba.entity.disciplina.dto.DisciplinaResponseDto;
import br.com.ifba.entity.disciplina.model.Disciplina;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;

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
    private IDisciplinaDao disciplinaDao;
    @Autowired
    private ObjectMapperUtil objectMapperUtil;


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

        return this.objectMapperUtil.mapAll(
                this.disciplinaDao.findAll(),
                DisciplinaResponseDto.class
        );

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
    public DisciplinaResponseDto encontrarDisciplinaPorId(UUID id) {

        return this.disciplinaDao.findById(id)
                .map(d -> this.objectMapperUtil.map(d, DisciplinaResponseDto.class))
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
    public List<DisciplinaResponseDto> encontrarDisciplinaPorNome(String nome) {

        return this.disciplinaDao.findByNome(nome)
                .stream()
                .map(d -> this.objectMapperUtil.map(d, DisciplinaResponseDto.class))
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
    public DisciplinaResponseDto salvarDisciplina(Disciplina disciplina) {

        // TODO: Adicionar verificação de código, para evitar cadastro de disciplinas com código repetido

        return this.objectMapperUtil.map(
                this.disciplinaDao.save(disciplina),
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
    public DisciplinaResponseDto atualizarDisciplina(Disciplina disciplina) {

        // TODO: Adicionar verificação de código, para evitar cadastro de disciplinas com código repetido

        return this.disciplinaDao.findById(disciplina.getId())
                .map(d -> this.objectMapperUtil.map(d, DisciplinaResponseDto.class))
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
    public DisciplinaResponseDto deletarDisciplinaPorId(UUID id) {

        return this.disciplinaDao.findById(id)
                .map(d -> {
                    this.disciplinaDao.delete(d);
                    return this.objectMapperUtil.map(d, DisciplinaResponseDto.class);
                })
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );


    }

}
