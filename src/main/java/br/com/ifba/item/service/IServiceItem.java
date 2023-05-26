/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.item.service;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ifba.item.model.Item;

/**
 *
 * @author vitor
 */
@Service
public interface IServiceItem {
    public abstract Item saveItem(Item item);

    public abstract Item updateItem(Item item);

    public abstract void deleteItem(Item item);

    public abstract List<Item> getAllItens();

    public List<Item> findByNome(String name);

    public abstract List<Item> dataNotBefore(Date dataNot);

    public abstract List<Item> validadeAfter(Date validade);
}
