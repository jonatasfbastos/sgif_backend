package br.com.ifba.sgif.api.entity.funcaotecnicoadministrativo.service;

import java.util.List;

import br.com.ifba.sgif.api.entity.funcaotecnicoadministrativo.dto.FuncaoTecnicoAdministrativoResponseDto;
import br.com.ifba.sgif.api.entity.funcaotecnicoadministrativo.model.FuncaoTecnicoAdministrativo;

/**
 * Interface de serviço para Função Técnico Administrativo.
 *
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
 */
public interface IServiceFuncaoTecnicoAdministrativo {

    /**
     * Salva uma Função Técnico Administrativo na base de dados e retorna um objeto DTO com os dados resumidos da Função Técnico Administrativo salva.
     *
     * @param funcaoTecnicoAdm - A Função Técnico Administrativo que será salva na base de dados.
     * @return um objeto DTO com os dados resumidos da Função Técnico Administrativo salva.
     */
    FuncaoTecnicoAdministrativoResponseDto saveFuncaoTecnicoAdm(FuncaoTecnicoAdministrativo funcaoTecnicoAdm);

    /**
     * Deleta uma Função Técnico Administrativo com base no ID.
     *
     * @param id - O ID da Função Técnico Administrativo a ser deletada.
     * @return um objeto DTO com os dados da Função Técnico Administrativo deletada.
     */
    FuncaoTecnicoAdministrativoResponseDto deleteFuncaoTecnicoAdm(Long id);

    /**
     * Obtém uma lista de todas as Funções Técnico Administrativo como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as Funções Técnico Administrativo.
     */
    List<FuncaoTecnicoAdministrativoResponseDto> getAllFuncoesTecnicoAdm();
}
