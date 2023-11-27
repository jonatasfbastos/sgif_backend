package br.com.ifba.sgif.api.entity.tipoturma.service;

import java.util.List;

import br.com.ifba.sgif.api.entity.tipoturma.dto.TipoTurmaResponseDto;
import br.com.ifba.sgif.api.entity.tipoturma.model.TipoTurma;

/**
 * Interface de serviço para Tipo de Turma.
 *
 * @author unknown
 * Editado por Andesson Reis
 * @since V1.0.1
 *
 */
public interface IServiceTipoTurma {

    /**
     * Salva um Tipo de Turma na base de dados e retorna um objeto DTO com os dados resumidos do Tipo de Turma salvo.
     *
     * @param tipoTurma - O Tipo de Turma que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do Tipo de Turma salvo.
     */
    TipoTurmaResponseDto saveTipoTurma(TipoTurma tipoTurma);

    /**
     * Atualiza um Tipo de Turma na base de dados e retorna um objeto DTO com os dados resumidos do Tipo de Turma atualizado.
     *
     * @param tipoTurma - O Tipo de Turma que será atualizado na base de dados.
     * @return um objeto DTO com os dados resumidos do Tipo de Turma atualizado.
     */
    TipoTurmaResponseDto updateTipoTurma(TipoTurma tipoTurma);

    /**
     * Deleta um Tipo de Turma com base no ID.
     *
     * @param id - O ID do Tipo de Turma a ser deletado.
     * @return um objeto DTO com os dados do Tipo de Turma deletado.
     */
    TipoTurmaResponseDto deleteTipoTurma(Long id);

    /**
     * Obtém uma lista de todos os Tipos de Turma como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os Tipos de Turma.
     */
    List<TipoTurmaResponseDto> getAllTipoTurma();
}
