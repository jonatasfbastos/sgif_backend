package br.com.ifba.entity.item.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.ifba.entity.item.dto.ItemSimpleResponseDto;
import br.com.ifba.entity.item.dto.ItemResponseDto;
import br.com.ifba.entity.item.model.Item;


/**
 *
 * @author vitor
 * @Editado por Andesson Reis
 * @since V1.0.1
 */
@Service
public interface IServiceItem {

    /**
     * Lista todos os itens na base de dados.
     *
     * @return uma lista com todos os itens na base de dados.
     * @author Andesson Reis
     * @since V1.0.1
     */
    List<ItemSimpleResponseDto> getAllItens();

    /**
     * Encontra um item pelo ID passado por parâmetro.
     *
     * @param id O ID do item a ser buscado na base de dados.
     * @return os dados do item atrelados àquele ID.
     * @author Andesson Reis
     * @since V1.0.1
     */
    ItemResponseDto getItemById(UUID id);

    /**
     * Salva um item na base de dados.
     *
     * @param item O item que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do item salvo.
     * @author Andesson Reis
     * @since V1.0.1
     */
    ItemSimpleResponseDto saveItem(Item item);

    /**
     * Atualiza um item existente na base de dados.
     *
     * @param item O item que será atualizado.
     * @return dados do item atualizado.
     * @author Andesson Reis
     * @since V1.0.1
     */
    ItemSimpleResponseDto updateItem(Item item);

    /**
     * Deleta um item.
     *
     * @param id O ID do item a ser deletado.
     * @return objeto DTO com os dados do item deletado.
     * @author Andesson Reis
     * @since V1.0.1
     */
    ItemSimpleResponseDto deleteItem(UUID id);

    /**
     * Busca itens pelo nome.
     *
     * @param name O nome do item a ser buscado.
     * @return uma lista de itens que correspondem ao nome especificado.
     * @author Andesson Reis
     * @since V1.0.1
     */
    List<ItemSimpleResponseDto> findByNome(String name);

    /**
     * Busca itens com data de notificação anterior à data fornecida.
     *
     * @param dataNot A data de notificação de referência.
     * @return uma lista de itens com data de notificação anterior à data especificada.
     * @author Andesson Reis
     * @since V1.0.1
     */
    List<ItemSimpleResponseDto> findByDataNotBefore(Date dataNot);

    /**
     * Busca itens com data de validade posterior à data fornecida.
     * 
     * @param validade A data de validade de referência.
     * @return uma lista de itens com data de validade posterior à data especificada.
     * @author Andesson Reis
     * @since V1.0.1
     */
    List<ItemSimpleResponseDto> findByValidadeAfter(Date validade);
}
