package br.com.ifba.entity.tipodeitem.service;

import java.util.List;

import br.com.ifba.entity.tipodeitem.model.TipoDeItem;


public interface IServiceTipoItem {

    public abstract TipoDeItem savetipoDeItem(TipoDeItem tipoDeItem);

    public abstract TipoDeItem updatetipoDeItem(TipoDeItem tipoDeItem);

    public abstract void deletetipoDeItem(TipoDeItem tipoDeItem);

    public abstract List<TipoDeItem> getAlltipoDeItem();
}
