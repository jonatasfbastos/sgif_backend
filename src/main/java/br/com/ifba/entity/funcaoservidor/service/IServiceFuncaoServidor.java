package br.com.ifba.entity.funcaoservidor.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.ifba.entity.funcaoservidor.dto.FuncaoServidorResponseDto;
import br.com.ifba.entity.funcaoservidor.model.FuncaoServidor;

/**
 * Interface de serviço para Função de Servidor.
 *
 * @author Gusd
 * @since V1.0.1
 * Editado por Andesson Reis
 */
@Service
public interface IServiceFuncaoServidor {

    /**
     * Salva uma Função de Servidor na base de dados e retorna um objeto DTO com os dados resumidos da Função de Servidor salva.
     *
     * @param funcaoServidor - A Função de Servidor que será salva na base de dados.
     * @return um objeto DTO com os dados resumidos da Função de Servidor salva.
     */
    FuncaoServidorResponseDto saveFuncaoServidor(FuncaoServidor funcaoServidor);

    /**
     * Atualiza uma Função de Servidor na base de dados e retorna um objeto DTO com os dados resumidos da Função de Servidor atualizada.
     *
     * @param funcaoServidor - A Função de Servidor que será atualizada na base de dados.
     * @return um objeto DTO com os dados resumidos da Função de Servidor atualizada.
     */
    FuncaoServidorResponseDto updateFuncaoServidor(FuncaoServidor funcaoServidor);

    /**
     * Deleta uma Função de Servidor com base no ID.
     *
     * @param id - O ID da Função de Servidor a ser deletada.
     * @return um objeto DTO com os dados da Função de Servidor deletada.
     */
    FuncaoServidorResponseDto deleteFuncaoServidor(UUID id);

    /**
     * Obtém uma lista de todas as Funções de Servidor como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as Funções de Servidor.
     */
    List<FuncaoServidorResponseDto> getAllFuncaoServidor();
}
