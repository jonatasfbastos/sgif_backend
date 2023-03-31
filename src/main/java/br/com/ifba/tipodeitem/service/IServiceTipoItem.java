package br.com.ifba.tipodeitem.service;

import java.util.List;

import br.com.ifba.tipodeitem.model.TipoDeItem;


public interface IServiceTipoItem {

    public abstract TipoDeItem savetipoDeItem(TipoDeItem tipoDeItem);

    public abstract TipoDeItem updatetipoDeItem(TipoDeItem tipoDeItem);

    public abstract void deletetipoDeItem(TipoDeItem tipoDeItem);

    public abstract List<TipoDeItem> getAlltipoDeItem();
}
