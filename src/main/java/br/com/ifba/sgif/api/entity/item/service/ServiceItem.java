package br.com.ifba.sgif.api.entity.item.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.ifba.sgif.api.infrastructure.exception.BusinessException;
import br.com.ifba.sgif.api.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.sgif.api.entity.item.dao.IDaoItem;
import br.com.ifba.sgif.api.entity.item.dto.ItemResponseDto;
import br.com.ifba.sgif.api.entity.item.dto.ItemSimpleResponseDto;
import br.com.ifba.sgif.api.entity.item.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service que fornece operações relacionadas a Item.
 *
 * @author vitor
 * Editado por Andesson Reis
 * @since Desde V1.0.1
 */
@Service
public class ServiceItem implements IServiceItem {

    @Autowired
    private IDaoItem daoItem;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
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
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Deleta um item pelo ID.
     *
     * @param id - O ID do item a ser deletado.
     * @return um objeto DTO com os dados do item deletado.
     * @throws BusinessException se o item não for encontrado.
     */
    @Override
    public ItemSimpleResponseDto deleteItem(Long id) {
        return this.daoItem.findById(id)
                .map(DeletItem -> {
                    daoItem.delete(DeletItem);
                    return objectMapperUtil.map(DeletItem, ItemSimpleResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
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
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
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

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
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
     * @since V1.0.1
     * <p>
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
     * @since V1.0.1
     * <p>
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

    /**
     * @since V1.0.1
     * <p>
     * Obtém um item por ID e mapeia para um objeto DTO.
     *
     * @param id - O ID do item a ser obtido.
     * @return um objeto DTO com os dados do item encontrado.
     * @throws BusinessException se o item não for encontrado.
     */
    @Override
    public ItemResponseDto getItemById(Long id) {
        return objectMapperUtil.map(
                daoItem.findById(id)
                        .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())),
                ItemResponseDto.class
        );
    }

    /**
     * Obtém uma data ajustada com base na data de validade e no período de alerta.
     *
     * @param data - A data de validade.
     * @param num - O período de alerta em dias.
     * @return a data ajustada.
     */
    public Date getDataAjuste(Date data, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DATE, -num);
        return calendar.getTime();
    }
}
