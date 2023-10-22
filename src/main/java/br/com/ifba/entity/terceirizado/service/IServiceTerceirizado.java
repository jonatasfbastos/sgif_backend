package br.com.ifba.entity.terceirizado.service;

import java.util.List;
import java.util.UUID;
import br.com.ifba.entity.terceirizado.dto.TerceirizadoResponseDto;
import br.com.ifba.entity.terceirizado.model.Terceirizado;

import org.springframework.stereotype.Service;

/**
 * Serviço para operações relacionadas à entidade 'Terceirizado'.
 *
 * @param terceirizado - O Terceirizado a ser salvo.
 */
@Service
public interface IServiceTerceirizado {

    /**
     * Salva um Terceirizado na base de dados e retorna um objeto DTO com os dados resumidos do Terceirizado salvo.
     *
     * @param terceirizado - O Terceirizado que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do Terceirizado salvo.
     */
    TerceirizadoResponseDto saveTerceirizado(Terceirizado terceirizado);

    /**
     * Atualiza um Terceirizado na base de dados e retorna um objeto DTO com os dados resumidos do Terceirizado atualizado.
     *
     * @param terceirizado - O Terceirizado que será atualizado na base de dados.
     * @return um objeto DTO com os dados resumidos do Terceirizado atualizado.
     */
    TerceirizadoResponseDto updateTerceirizado(Terceirizado terceirizado);

    /**
     * Deleta um Terceirizado.
     *
     * @param Id - O ID do Terceirizado a ser deletado.
     * @return objeto DTO com os dados do Terceirizado deletado.
     */
    TerceirizadoResponseDto deleteTerceirizado(UUID Id);

    /**
     * Obtém uma lista de todos os Terceirizados como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os Terceirizados.
     */
    List<TerceirizadoResponseDto> getAllTerceirizados();
}
