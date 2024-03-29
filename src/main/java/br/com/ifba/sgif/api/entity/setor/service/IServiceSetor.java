package br.com.ifba.sgif.api.entity.setor.service;

import br.com.ifba.sgif.api.entity.setor.dto.SetorResponseDto;
import br.com.ifba.sgif.api.entity.setor.model.Setor;

import java.util.List;

/**
 * @author Everton.
 * Editado por Andesson Reis
 * @since V1.0.1
 * 
 * Interface para serviços relacionados à entidade Setor.
 * 
 * Veja também: {@link Setor}
 */
public interface IServiceSetor {

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * Salva um novo setor.
     *
     * @param setor O setor a ser salvo.
     * @return Um DTO representando o setor salvo.
     */
    SetorResponseDto saveSetor(Setor setor);

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * Atualiza um setor existente.
     *
     * @param setor O setor a ser atualizado.
     * @return Um DTO representando o setor atualizado.
     */
    SetorResponseDto updateSetor(Setor setor);

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * Exclui um setor com base no seu ID.
     *
     * @param id O ID do setor a ser excluído.
     * @return Um DTO representando o setor excluído.
     */
    SetorResponseDto deleteSetor(Long id);

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * Retorna uma lista de todos os setores.
     *
     * @return Uma lista de DTOs representando todos os setores.
     */
    List<SetorResponseDto> getAllSetor();
}
