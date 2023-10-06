package br.com.ifba.entity.tipodeitem.dao;

import java.util.List;

import br.com.ifba.entity.tipodeitem.model.TipoDeItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dudasss
 */
public interface IDaoTipoItem extends JpaRepository<TipoDeItem, Long> {

    public abstract List<TipoDeItem> findByNome(String name);
}