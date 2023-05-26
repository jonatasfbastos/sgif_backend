/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.item.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.item.model.Item;

/**
 *
 * @author vitor
 */
public interface IDaoItem extends JpaRepository<Item, Long> {

    public abstract List<Item> findByNome(String name);

    public abstract List<Item> dataNotBefone(Date dataNot);

    public abstract List<Item> validadeAfter(Date validade);
}
