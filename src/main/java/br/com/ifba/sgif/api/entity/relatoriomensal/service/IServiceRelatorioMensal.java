package br.com.ifba.sgif.api.entity.relatoriomensal.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.relatoriomensal.dto.RelatorioMensalResponseDto;
import br.com.ifba.sgif.api.entity.relatoriomensal.model.RelatorioMensal;

/**
 * Interface de serviço para Relatório Mensal.
 *
 * @author unknown
 * Editado por Andesson Reis
 * @since V1.0.1
 */
public interface IServiceRelatorioMensal {

    /**
     * Salva um Relatório Mensal na base de dados e retorna um objeto DTO com os dados resumidos do Relatório Mensal salvo.
     *
     * @param relatorio - O Relatório Mensal que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do Relatório Mensal salvo.
     */
    RelatorioMensalResponseDto saveRelatorioMensal(RelatorioMensal relatorio);

    /**
     * Obtém uma lista de todos os Relatórios Mensais como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os Relatórios Mensais.
     */
    List<RelatorioMensalResponseDto> getAllRelatorioMensal();

    /**
     * Deleta um Relatório Mensal com base no ID.
     *
     * @param id - O ID do Relatório Mensal a ser deletado.
     * @return um objeto DTO com os dados do Relatório Mensal deletado.
     */
    RelatorioMensalResponseDto delete(UUID id);
}
