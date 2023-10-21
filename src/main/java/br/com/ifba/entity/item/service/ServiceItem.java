package br.com.ifba.entity.item.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.entity.item.dao.IDaoItem;
import br.com.ifba.entity.item.dto.ItemSimpleResponseDto;
import br.com.ifba.entity.item.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vitor
 * @Editado por Andesson Reis
 * @since Desde V1.0.1
 */
@Service
public class ServiceItem implements IServiceItem {

    // =========================================================== //
    // ======================== [ ATRIBUTOS ] ==================== //
    // =========================================================== //

    @Autowired
    private IDaoItem daoItem;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // ======================== [ MÉTODOS ] ====================== //
    // =========================================================== //

    /**
     * Salva um item na base de dados e retorna um objeto DTO com os dados do item salvo.
     *
     * @param item - O item que será salvo na base de dados.
     * @return um objeto DTO com os dados do item salvo.
     */
    @Override
    public ItemSimpleResponseDto saveItem(Item item) {

        return Optional.of(item)
                .map(savedItem -> {
                    savedItem.setDataNot(getDataAjuste(savedItem.getValidade(), savedItem.getAlerta()));
                    return daoItem.save(savedItem);
                })
                .map(savedItem -> objectMapperUtil.map(savedItem, ItemSimpleResponseDto.class))
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * Deleta um item pelo ID.
     *
     * @param id - O ID do item a ser deletado.
     * @return um objeto DTO com os dados do item deletado.
     * @throws BusinessException se o item não for encontrado.
     */
    @Override
    public ItemSimpleResponseDto deleteItem(UUID id) {

        return this.daoItem.findById(id)
                .map(DeletItem -> {
                    daoItem.delete(DeletItem);
                    return objectMapperUtil.map(DeletItem, ItemSimpleResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

    }


    /**
     * Obtém uma lista de todos os itens como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os itens.
     */
    @Override
    public List<ItemSimpleResponseDto> getAllItens() {

        return objectMapperUtil.mapAll(
                this.daoItem.findAll(),
                ItemSimpleResponseDto.class);
    }

    /**
     * Obtém uma lista de itens por nome como objetos DTO.
     *
     * @param name - O nome a ser pesquisado.
     * @return uma lista de objetos DTO representando os itens encontrados.
     */
    @Override
    public List<ItemSimpleResponseDto> findByNome(String name) {
        return daoItem.findByNome(name)
                .stream()
                .map(objectMapperUtil.mapFn(ItemSimpleResponseDto.class))
                .collect(Collectors.toList());
    }

    
    public Date getDataAjuste(Date data, int num) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DATE, -num);

        return calendar.getTime();
    }


    /**
     * Atualiza um item na base de dados.
     *
     * @param item - O item a ser atualizado.
     * @return um objeto DTO com os dados do item atualizado.
     * @throws BusinessException se o item com o ID especificado não for encontrado.
     */    
    @Override
    public ItemSimpleResponseDto updateItem(Item item) {
    
        return Optional.ofNullable(item)
                    .filter(itemToSave -> daoItem.existsById(itemToSave.getId()))
                    .map(itemToSave -> {
                        itemToSave.setDataNot(getDataAjuste(itemToSave.getValidade(), itemToSave.getAlerta()));
                        return daoItem.save(itemToSave);
                    })
                    .map(savedItem -> objectMapperUtil.map(savedItem, ItemSimpleResponseDto.class))
                    .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }
    
    /**
     * Obtém uma lista de itens com data anterior à data especificada.
     *
     * @param dataNot - A data de referência.
     * @return uma lista de itens com data anterior à data especificada.
     */
    @Override
    public List<ItemSimpleResponseDto> findByDataNotBefore(Date dataNot) {

         return objectMapperUtil.mapAll(
                this.daoItem.dataNotBefore(dataNot),
                ItemSimpleResponseDto.class);
    }

    /**
     * Obtém uma lista de itens com validade posterior à data especificada.
     *
     * @param validade - A data de validade de referência.
     * @return uma lista de itens com validade posterior à data especificada.
     */
    @Override
    public List<ItemSimpleResponseDto> findByValidadeAfter(Date validade) {

        return objectMapperUtil.mapAll(
                this.daoItem.validadeAfter(validade),
                ItemSimpleResponseDto.class);
    }

}
