/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.item.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.item.dao.IDaoItem;
import br.com.ifba.item.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vitor
 */
@Service
public class ServiceItem implements IServiceItem {

    // Constantes para condições de erro

    // Item Null
    public final static String ITEM_NULL = "Item null";

    // Item já existe
    public final static String ITEM_EXISTE = "Item já existe";

    // Item não existente
    public final static String ITEM_NAO_EXISTE = "O item já existe na base de dados";

    // Item inválido
    public final static String ITEM_INVALIDO = "Item inválido";

    // Criando objeto de instância
    @Autowired
    private IDaoItem daoItem;

    @Override
    public Item saveItem(Item item) {
        if (item == null) {
            throw new BusinessException(ITEM_NULL);
        } else {
            item.setDataNot(getDataAjuste(item.getValidade(), item.getAlerta()));
            return daoItem.save(item);
        }
    }

    public Date getDataAjuste(Date data, int num){

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
    public void deleteItem(Item item) {
        if (item == null) {
            throw new BusinessException(ITEM_NULL);
        } else {
            this.daoItem.delete(item);
            return;
        }

    }

    @Override
    public List<Item> getAllItens() {
        return daoItem.findAll();
    }

    @Override
    public List<Item> findByNome(String name) {
        if (name == null) {
            throw new BusinessException("Nome null");
        } else if (name.isEmpty()) {
            throw new BusinessException("Nome vazio");
        } else {
            return daoItem.findByNome(name);
        }
    }

    @Override
    public List<Item> dataNotBefore(Date dataNot) {
        return daoItem.dataNotBefore(dataNot);
    }

    @Override
    public List<Item> validadeAfter(Date validade) {
        return daoItem.validadeAfter(validade);
    }

}
