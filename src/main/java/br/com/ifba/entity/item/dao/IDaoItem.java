package br.com.ifba.entity.item.dao;

import java.util.Date;
import java.util.List;

import br.com.ifba.entity.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author vitor
 */
@Repository
public interface IDaoItem extends JpaRepository<Item, Long> {

    List<Item> findByNome(String name);

    List<Item> dataNotBefore(Date dataNot);

    List<Item> validadeAfter(Date validade);
}
