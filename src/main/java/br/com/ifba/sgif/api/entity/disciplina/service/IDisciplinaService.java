package br.com.ifba.sgif.api.entity.disciplina.service;

import java.util.List;

import br.com.ifba.sgif.api.entity.disciplina.dto.DisciplinaResponseDto;
import br.com.ifba.sgif.api.entity.disciplina.model.Disciplina;
import org.springframework.stereotype.Service;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Service
public interface IDisciplinaService {


    // =========================================================== //
    // =============== [ ASSINATURAS DE MÉTODOS ] ================ //
    // =========================================================== //

    /**
     * Lista todas as disciplinas cadastradas na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return uma lista de DTO com dados de todas as disciplinas da base de dados.
     */
    List<DisciplinaResponseDto> listarDisciplinas();


    /**
     * Lista todas as disciplinas cadastradas na base de dados
     * que possuam o professor passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param professor O nome do professor.
     * @return uma lista de DTO com dados de todas as disciplinas da base de dados.
     */
    List<DisciplinaResponseDto> listarDisciplinas(final String professor);

    /**
     * Busca uma disciplina na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da disciplina a ser buscada.
     * @return DTO com dados da disciplina atrelada ao ID passado por parâmetro.
     */
    DisciplinaResponseDto encontrarDisciplinaPorId(final Long id);

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
    List<DisciplinaResponseDto> encontrarDisciplinaPorNome(final String nome);

    /**
     * Salva uma disciplina na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param disciplina A disciplina a ser salva na base de dados.
     * @return DTO com dados da disciplina salva.
     */
    DisciplinaResponseDto salvarDisciplina(final Disciplina disciplina);

    /**
     * Atualiza uma disciplina existente na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param disciplina A disciplina a ser atualizada.
     * @return DTO com dados da disciplina atualizada.
     */
    DisciplinaResponseDto atualizarDisciplina(final Disciplina disciplina);


    /**
     * Deleta uma disciplina na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da disciplina a ser deletada.
     * @return DTO com dados da disciplina deletada.
     */
    DisciplinaResponseDto deletarDisciplinaPorId(final Long id);

}
