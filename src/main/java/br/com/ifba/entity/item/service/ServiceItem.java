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

    @Override
    public ItemSimpleResponseDto deleteItem(UUID id) {

        return this.daoItem.findById(id)
                .map(DeletItem -> {
                    daoItem.delete(DeletItem);
                    return objectMapperUtil.map(DeletItem, ItemSimpleResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

    }

    @Override
    public List<ItemSimpleResponseDto> getAllItens() {

        return objectMapperUtil.mapAll(
                this.daoItem.findAll(),
                ItemSimpleResponseDto.class);
    }

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

    @Override
    public Item updateItem(Item item) {
        if (item == null) {
            throw new BusinessException(ITEM_NULL);
        } else if (daoItem.findById(item.getId()) == null) {
            throw new BusinessException(ITEM_EXISTE);
        } else {
            item.setDataNot(getDataAjuste(item.getValidade(), item.getAlerta()));
            return daoItem.save(item);
        }
    }

    @Override
    public List<Item> dataNotBefore(Date dataNot) {
        return daoItem.dataNotBeforae(dataNot);
    }

    @Override
    public List<Item> validadeAfter(Date validade) {
        return daoItem.validadeAfter(validade);
    }

}
