package br.com.ifba.item.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.item.model.Item;
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
