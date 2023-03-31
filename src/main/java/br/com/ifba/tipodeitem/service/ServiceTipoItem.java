



package br.com.ifba.tipodeitem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.tipodeitem.dao.IDaoTipoItem;
import br.com.ifba.tipodeitem.model.TipoDeItem;

@Service
public class ServiceTipoItem implements IServiceTipoItem{

    // mensagem de erro se o tipoDeItem for null;
    public final static String tipoDeItem_NULL = "Tipo de Item null";

    // mensagem de erro se o tipoDeItem já existir;
    public final static String tipoDeItem_EXISTE = "O Tipo de Item já existe,";

    // mensagem de erro se o tipoDeItem não existir no banco;
    public final static String tipoDeItem_NAO_EXISTE = "O Tipo de Item não existe na base de dados";

    // mensagem de erro se o tipoDeItem for inválido;
    public final static String tipoDeItem_INVALIDO = "Tipo de Item inválido";

    // OBJETO
    @Autowired
    private IDaoTipoItem daoTipoDeItem;


    @Override
    public TipoDeItem savetipoDeItem(TipoDeItem tipoDeItem) {
        if(tipoDeItem == null){
            throw new BusinessException(tipoDeItem_NULL);
        }else{
            return daoTipoDeItem.save(tipoDeItem);
        }
    }

    @Override
    public TipoDeItem updatetipoDeItem(TipoDeItem tipoDeItem) {
        if(tipoDeItem == null){
            throw new BusinessException(tipoDeItem_NULL);
        }else if(daoTipoDeItem.findById(tipoDeItem.getId()) == null){
            throw new BusinessException(tipoDeItem_NAO_EXISTE);
        }else{
            return daoTipoDeItem.save(tipoDeItem);
        }
    }

    @Override
    public void deletetipoDeItem(TipoDeItem tipoDeItem) {
        if(tipoDeItem == null){
            throw new BusinessException(tipoDeItem_NULL);
        }else{
            this.daoTipoDeItem.delete(tipoDeItem);
        }
        
    }

    @Override
    public List<TipoDeItem> getAlltipoDeItem() {
        return (List<TipoDeItem>)this.daoTipoDeItem.findAll();
    }
    
}
