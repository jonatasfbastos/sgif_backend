package br.com.ifba.entity.tipodeitem.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.entity.tipodeitem.dto.TipoDeItemResponseDto;
import br.com.ifba.entity.tipodeitem.model.TipoDeItem;

import org.springframework.stereotype.Service;

/**
 * Interface de serviço para TipoDeItem.
 *
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
 */
@Service
public interface ITipoDeItemService {

    /**
     * Salva um TipoDeItem na base de dados e retorna um objeto DTO com os dados resumidos do TipoDeItem salvo.
     *
     * @param tipoDeItem - O TipoDeItem que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do TipoDeItem salvo.
     */
    TipoDeItemResponseDto saveTipoDeItem(TipoDeItem tipoDeItem);

    /**
     * Atualiza um TipoDeItem na base de dados e retorna um objeto DTO com os dados resumidos do TipoDeItem atualizado.
     *
     * @param tipoDeItem - O TipoDeItem que será atualizado na base de dados.
     * @return um objeto DTO com os dados resumidos do TipoDeItem atualizado.
     */
    TipoDeItemResponseDto updateTipoDeItem(TipoDeItem tipoDeItem);

    /**
     * Deleta um TipoDeItem.
     *
     * @param ID - O id a ser deletado.
     * @return objeto DTO com os dados do TipoDeItem deletado.
     */
    TipoDeItemResponseDto deleteTipoDeItem(UUID ID);

    /**
     * Obtém uma lista de todos os TiposDeItem como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os TiposDeItem.
     */
    List<TipoDeItemResponseDto> getAllTiposDeItem();
}
