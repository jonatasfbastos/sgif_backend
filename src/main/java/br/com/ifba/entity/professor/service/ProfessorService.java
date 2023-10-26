package br.com.ifba.entity.professor.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.ifba.entity.professor.dao.IProfessorDao;
import br.com.ifba.entity.professor.dto.ProfessorResponseDto;
import br.com.ifba.entity.professor.model.Professor;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;

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
    public List<ProfessorResponseDto> listarProfessores() {

        return this._objectMapperUtil.mapAll(
                this._professorDao.findAll(),
                ProfessorResponseDto.class
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
     public ProfessorResponseDto encontrarProfessorPorId(final UUID id) {


        return this._professorDao.findById(id)
                .map(prof -> this._objectMapperUtil.map(this._professorDao.save(prof), ProfessorResponseDto.class))
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
    public List<ProfessorResponseDto> encontrarProfessorPorNome(final String nome) {

         return this._professorDao.findByNome(nome)
                 .stream()
                 .map(prof -> this._objectMapperUtil.map(this._professorDao.save(prof), ProfessorResponseDto.class))
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
    public ProfessorResponseDto salvarProfessor(final Professor professor) {

        // TODO: Adicionar verificação de SIAPE

        return this._objectMapperUtil.map(
                this._professorDao.save(professor),
                ProfessorResponseDto.class
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
    public ProfessorResponseDto atualizarProfessor(final Professor professor) {

        // TODO: Adicionar verificação de SIAPE

        return this._professorDao.findById(professor.getId())
                .map(prof -> this._objectMapperUtil.map(prof, ProfessorResponseDto.class))
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
    public ProfessorResponseDto deletarProfessorPorId(final UUID id) {

         return this._professorDao.findById(id)
                 .map(prof -> {
                     this._professorDao.delete(prof);
                     return this._objectMapperUtil.map(prof, ProfessorResponseDto.class);
                 })
                 .orElseThrow(
                         () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                 );


    }



}
