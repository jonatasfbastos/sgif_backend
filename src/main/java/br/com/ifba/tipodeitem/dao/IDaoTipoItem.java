package br.com.ifba.tipodeitem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.tipodeitem.model.TipoDeItem;

/**
 *
 * @author dudasss
 */
public interface IDaoTipoItem extends JpaRepository<TipoDeItem, Long> {

    public abstract List<TipoDeItem> findByNome(String name);
}