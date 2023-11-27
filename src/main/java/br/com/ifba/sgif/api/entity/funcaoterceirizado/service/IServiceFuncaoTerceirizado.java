package br.com.ifba.sgif.api.entity.funcaoterceirizado.service;

import br.com.ifba.sgif.api.entity.funcaoterceirizado.dto.FuncaoTerceirizadoResponseDto;
import br.com.ifba.sgif.api.entity.funcaoterceirizado.model.FuncaoTerceirizado;

import java.util.List;

/**
 *
 * @author ph715
 * @since V1.0.1
 * Editado por Andesson Reis
 */
public interface IServiceFuncaoTerceirizado {

    /**
     * Salva uma Função de Terceirizado na base de dados e retorna um objeto DTO com os dados resumidos da Função salva.
     *
     * @param funcaoTerceirizado - A Função de Terceirizado que será salva na base de dados.
     * @return um objeto DTO com os dados resumidos da Função salva.
     */
    FuncaoTerceirizadoResponseDto saveFuncaoTerceirizado(FuncaoTerceirizado funcaoTerceirizado);

    /**
     * Deleta uma Função de Terceirizado.
     *
     * @param id - O ID da Função de Terceirizado a ser deletada.
     * @return um objeto DTO com os dados da Função de Terceirizado deletada.
     */
    FuncaoTerceirizadoResponseDto deleteFuncaoTerceirizado(Long id);

    /**
     * Obtém uma lista de todas as Funções de Terceirizado como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as Funções de Terceirizado.
     */
    List<FuncaoTerceirizadoResponseDto> getAllFuncoesTerceirizado();
}
