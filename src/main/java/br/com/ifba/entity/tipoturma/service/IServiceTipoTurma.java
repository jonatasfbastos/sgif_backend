package br.com.ifba.entity.tipoturma.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.entity.tipoturma.dto.TipoTurmaResponseDto;
import br.com.ifba.entity.tipoturma.model.TipoTurma;

/**
 * Interface de serviço para Tipo de Turma.
 *
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
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
    TipoTurmaResponseDto deleteTipoTurma(UUID id);

    /**
     * Obtém uma lista de todos os Tipos de Turma como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os Tipos de Turma.
     */
    List<TipoTurmaResponseDto> getAllTipoTurma();
}
