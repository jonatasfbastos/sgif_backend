package br.com.ifba.sgif.api.entity.questao.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.questao.dto.QuestaoResponseDto;
import br.com.ifba.sgif.api.entity.questao.model.Questao;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
public interface IQuestaoService {

    // =========================================================== //
    // =============== [ ASSINATURAS DE MÉTODOS ] ================ //
    // =========================================================== //

    /**
     * Lista todas as questões cadastradas na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return uma lista de DTO com dados de todas as questões da base de dados.
     */
    List<QuestaoResponseDto> listarQuestoes();

    /**
     * Busca uma questão na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da questão a ser buscada.
     * @return DTO com dados da  questão atrelada ao ID passado por parâmetro.
     */
    QuestaoResponseDto encontrarQuestaoPorId(UUID id);

    /**
     * Busca questões na base de dados com base no enunciado passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param enunciado O enunciado das questões a serem buscadas.
     * @return Lista de DTO com dados das questões que possuem o enunciado passado por parâmetro.
     */
    List<QuestaoResponseDto> encontrarQuestaoPorEnunciado(String enunciado);

    /**
     * Salva uma questão na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param questao A questão a ser salva na base de dados.
     * @return DTO com dados da questão salva.
     */
    QuestaoResponseDto salvarQuestao(Questao questao);


    /**
     * Atualiza uma questão existente na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param questao A questão a ser atualizada.
     * @return DTO com dados da questão atualizada.
     */
    QuestaoResponseDto atualizarQuestao(Questao questao);

    /**
     * Deleta uma questão na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da questão a ser deletada.
     * @return DTO com dados da questão deletada.
     */
    QuestaoResponseDto deletarQuestaoPorId(UUID id);


}
