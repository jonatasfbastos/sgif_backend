package br.com.ifba.sgif.api.entity.professor.service;

import java.util.List;

import br.com.ifba.sgif.api.entity.professor.dto.ProfessorGetResponseDto;
import br.com.ifba.sgif.api.entity.professor.dto.ProfessorSimpleResponseDto;
import br.com.ifba.sgif.api.entity.professor.model.Professor;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
public interface IProfessorService {

    // =========================================================== //
    // =============== [ ASSINATURAS DE MÉTODOS ] ================ //
    // =========================================================== //

    /**
     * Lista todas os professores cadastrados na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return uma lista de DTO com dados de todos os professores da base de dados.
     */
    List<ProfessorGetResponseDto> listarProfessores();

    /**
     * Busca um professor na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID do professor a ser buscado.
     * @return DTO com dados do professor atrelado ao ID passado por parâmetro.
     */
    ProfessorSimpleResponseDto encontrarProfessorPorId(final Long id);

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
    List<ProfessorSimpleResponseDto> encontrarProfessorPorNome(final String nome);

    /**
     * Salva um professor na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param professor O professor a ser salvo na base de dados.
     * @return DTO com dados do professor salvo.
     */
    ProfessorSimpleResponseDto salvarProfessor(final Professor professor);

    /**
     * Atualiza um professor existente na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param professor O professor a ser atualizado.
     * @return DTO com dados do professor atualizado.
     */
    ProfessorSimpleResponseDto atualizarProfessor(final Professor professor);

    /**
     * Deleta um professor na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID do professor a ser deletado.
     * @return DTO com dados do professor deletado.
     */
    ProfessorSimpleResponseDto deletarProfessorPorId(final Long id);

}
