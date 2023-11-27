package br.com.ifba.sgif.api.entity.servidor.service;

import java.util.List;

import br.com.ifba.sgif.api.entity.servidor.dto.ServidorResponseDto;
import br.com.ifba.sgif.api.entity.servidor.model.Servidor;

/**
 * Interface de serviço para Servidor.
 *
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
 */
public interface IServiceServidor {

    /**
     * Salva um Servidor na base de dados e retorna um objeto DTO com os dados resumidos do Servidor salvo.
     *
     * @param servidor - O Servidor que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do Servidor salvo.
     */
    ServidorResponseDto saveServidor(Servidor servidor);

    /**
     * Atualiza um Servidor na base de dados e retorna um objeto DTO com os dados resumidos do Servidor atualizado.
     *
     * @param servidor - O Servidor que será atualizado na base de dados.
     * @return um objeto DTO com os dados resumidos do Servidor atualizado.
     */
    ServidorResponseDto updateServidor(Servidor servidor);

    /**
     * Deleta um Servidor com base no ID.
     *
     * @param id - O ID do Servidor a ser deletado.
     * @return um objeto DTO com os dados do Servidor deletado.
     */
    ServidorResponseDto deleteServidor(Long id);

    /**
     * Obtém uma lista de todos os Servidores como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os Servidores.
     */
    List<ServidorResponseDto> getAllServidor();
}
