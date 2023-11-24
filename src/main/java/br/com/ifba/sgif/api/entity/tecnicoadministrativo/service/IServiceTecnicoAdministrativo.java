package br.com.ifba.sgif.api.entity.tecnicoadministrativo.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.tecnicoadministrativo.dto.TecnicoAdministrativoResponseDto;
import br.com.ifba.sgif.api.entity.tecnicoadministrativo.model.TecnicoAdministrativo;

/**
 * Interface de serviço para Técnico Administrativo.
 *
 * @author unknown
 * @since V1.0.1
 * @Editado por Andesson Reis
 */
public interface IServiceTecnicoAdministrativo {

    /**
     * Salva um Técnico Administrativo na base de dados e retorna um objeto DTO com os dados resumidos do Técnico Administrativo salvo.
     *
     * @param tecnicoAdministrativo - O Técnico Administrativo que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do Técnico Administrativo salvo.
     */
    TecnicoAdministrativoResponseDto saveTecnicoAdministrativo(TecnicoAdministrativo tecnicoAdministrativo);

    /**
     * Atualiza um Técnico Administrativo na base de dados e retorna um objeto DTO com os dados resumidos do Técnico Administrativo atualizado.
     *
     * @param tecnicoAdministrativo - O Técnico Administrativo que será atualizado na base de dados.
     * @return um objeto DTO com os dados resumidos do Técnico Administrativo atualizado.
     */
    TecnicoAdministrativoResponseDto updateTecnicoAdministrativo(TecnicoAdministrativo tecnicoAdministrativo);

    /**
     * Deleta um Técnico Administrativo com base no ID.
     *
     * @param id - O ID do Técnico Administrativo a ser deletado.
     * @return um objeto DTO com os dados do Técnico Administrativo deletado.
     */
    TecnicoAdministrativoResponseDto deleteTecnicoAdministrativo(UUID id);

    /**
     * Obtém uma lista de todos os Técnicos Administrativos como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os Técnicos Administrativos.
     */
    List<TecnicoAdministrativoResponseDto> getAllTecnicoAdministrativo();
}
