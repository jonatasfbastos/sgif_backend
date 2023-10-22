package br.com.ifba.entity.avaliacao.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.entity.avaliacao.dto.AvaliacaoResponseDto;
import br.com.ifba.entity.avaliacao.model.Avaliacao;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
public interface IAvaliacaoService {

    /**
     * Lista todas as avaliações cadastradas na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return uma lista com todas as turmas da base de dados, ou nulo, caso não exista nenhuma.
     */
    List<AvaliacaoResponseDto> listarAvaliacoes();

    /**
     * Busca uma avaliacao na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da avaliação a ser buscada.
     * @return DTO com dados da avaliação atrelada ao ID passado por parâmetro.
     */
    AvaliacaoResponseDto encontrarAvaliacaoPorId(UUID id);

    /**
     * Salva uma avaliação na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param avaliacao A avaliação a ser salva na base de dados.
     * @return DTO com dados da avaliação salva.
     */
    AvaliacaoResponseDto salvarAvaliacao(Avaliacao avaliacao);

    /**
     * Atualiza uma avaliação existente na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param avaliacao A avaliação a ser atualizada.
     * @return DTO com dados da avaliação atualizada.
     */
    AvaliacaoResponseDto atualizarAvaliacao(Avaliacao avaliacao);

    /**
     * Deleta uma avaliação na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da avaliação a ser deletada.
     * @return DTO om dados da avaliação deletada.
     */
    AvaliacaoResponseDto deletarAvaliacaoPorId(UUID id);

    // List<Avaliacao> filtrarAvaliacao(String dtInicio, String dtFim, Long idDisciplina);
    
}
