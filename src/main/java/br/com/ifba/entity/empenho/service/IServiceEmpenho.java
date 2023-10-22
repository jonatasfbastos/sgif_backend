package br.com.ifba.entity.empenho.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.entity.empenho.dto.EmpenhoResponseDto;
import br.com.ifba.entity.empenho.model.Empenho;

/**
 * Interface para serviços relacionados à entidade Empenho.
 *
 * @author rocki.julius
 * @Editado por Andesson Reis
 * @since V1.0.1
 * 
 * Veja também: {@link br.com.ifba.entity.empenho.model.Empenho}
 */
public interface IServiceEmpenho {

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * Salva um novo empenho.
     *
     * @param empenho O empenho a ser salvo.
     * @return Um DTO representando o empenho salvo.
     */
    EmpenhoResponseDto saveEmpenho(Empenho empenho);

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * Atualiza um empenho existente.
     *
     * @param empenho O empenho a ser atualizado.
     * @return Um DTO representando o empenho atualizado.
     */
    EmpenhoResponseDto updateEmpenho(Empenho empenho);

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * Exclui um empenho com base no seu ID.
     *
     * @param id O ID do empenho a ser excluído.
     * @return Um DTO representando o empenho excluído.
     */
    EmpenhoResponseDto deleteEmpenho(UUID id);

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * Retorna uma lista de todos os empenhos.
     *
     * @return Uma lista de DTOs representando todos os empenhos.
     */
    List<EmpenhoResponseDto> getAllEmpenho();
}
