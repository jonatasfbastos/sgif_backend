package br.com.ifba.sgif.api.entity.professor.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.ifba.sgif.api.entity.professor.dao.IProfessorDao;
import br.com.ifba.sgif.api.entity.professor.dto.ProfessorGetResponseDto;
import br.com.ifba.sgif.api.entity.professor.dto.ProfessorSimpleResponseDto;
import br.com.ifba.sgif.api.entity.professor.model.Professor;
import br.com.ifba.sgif.api.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.sgif.api.infrastructure.exception.BusinessException;

@Service
public class ProfessorService implements IProfessorService {

    // =========================================================== //
    // =============== [       ATRIBUTOS        ] ================ //
    // =========================================================== //

    @Autowired
    private IProfessorDao _professorDao;
    @Autowired
    private ObjectMapperUtil _objectMapperUtil;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    /**
     * Lista todas os professores cadastrados na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return uma lista de DTO com dados de todos os professores da base de dados.
     */
    @Override
    public List<ProfessorSimpleResponseDto> listarProfessores() {

        return this._objectMapperUtil.mapAll(
                this._professorDao.findAll(),
                ProfessorSimpleResponseDto.class
        );

    }

    /**
     * Busca um professor na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID do professor a ser buscado.
     * @return DTO com dados do professor atrelado ao ID passado por parâmetro.
     */
     @Override
     public ProfessorSimpleResponseDto encontrarProfessorPorId(final Long id) {


        return this._professorDao.findById(id)
                .map(prof -> this._objectMapperUtil.map(this._professorDao.save(prof), ProfessorSimpleResponseDto.class))
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );
     }

    /**
     * Busca professores na base de dados com base no nome
     * passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param nome O nome dos professores a serem buscados.
     * @return Lista de DTO com dados dos professores que possuem o nome
     * passado por parâmetro.
     */
    @Override
    public List<ProfessorSimpleResponseDto> encontrarProfessorPorNome(final String nome) {

         return this._professorDao.findByNome(nome)
                 .stream()
                 .map(prof -> this._objectMapperUtil.map(this._professorDao.save(prof), ProfessorSimpleResponseDto.class))
                 .collect(Collectors.toList());

    }

    /**
     * Salva um professor na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param professor O professor a ser salvo na base de dados.
     * @return DTO com dados do professor salvo.
     */
    @Override
    public ProfessorSimpleResponseDto salvarProfessor(final Professor professor) {

        // TODO: Adicionar verificação de SIAPE

        return this._objectMapperUtil.map(
                this._professorDao.save(professor),
                ProfessorGetResponseDto.class
        );

    }

    /**
     * Atualiza um professor existente na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param professor O professor a ser atualizado.
     * @return DTO com dados do professor atualizado.
     */
    @Override
    public ProfessorSimpleResponseDto atualizarProfessor(final Professor professor) {

        // TODO: Adicionar verificação de SIAPE

        return this._professorDao.findById(professor.getId())
                .map(prof -> this._objectMapperUtil.map(prof, ProfessorSimpleResponseDto.class))
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );
    }

    /**
     * Deleta um professor na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID do professor a ser deletado.
     * @return DTO com dados do professor deletado.
     */
    @Override
    public ProfessorSimpleResponseDto deletarProfessorPorId(final Long id) {

         return this._professorDao.findById(id)
                 .map(prof -> {
                     this._professorDao.delete(prof);
                     return this._objectMapperUtil.map(prof, ProfessorSimpleResponseDto.class);
                 })
                 .orElseThrow(
                         () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                 );


    }



}
