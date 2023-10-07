package br.com.ifba.entity.tipodeitem.dao;

import java.util.List;

import br.com.ifba.entity.tipodeitem.model.TipoDeItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dudasss
 */
@Repository
public interface IDaoTipoItem extends JpaRepository<TipoDeItem, Long> {

    List<TipoDeItem> findByNome(String name);
}