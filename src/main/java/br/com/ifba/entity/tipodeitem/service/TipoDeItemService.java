package br.com.ifba.entity.tipodeitem.service;

import java.util.List;

import br.com.ifba.entity.tipodeitem.model.TipoDeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.entity.setor.dao.IDaoSetor;
import br.com.ifba.entity.tipodeitem.dao.IDaoTipoItem;
import br.com.ifba.entity.tipodeitem.dto.TipoDeItemResponseDto;

/**
 * Service que fornece operações relacionadas a TipoDeItem
 *
 * @author unknown
 * @since V1.0.1
 * @Editado por Andesson Reis
 */
@Service
public class TipoDeItemService implements ITipoDeItemService{

    // =========================================================== //
    // ======================= [ ATRIBUTOS ] ===================== //
    // =========================================================== //

    @Autowired
    private IDaoTipoItem daoTipoDeItem;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // ========================= [ MÉTODOS ] ===================== //
    // =========================================================== //


    /**
     * Salva um TipoDeItem na base de dados e retorna um objeto DTO com os dados resumidos do TipoDeItem salvo.
     *
     * @param tipoDeItem - O TipoDeItem que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do TipoDeItem salvo.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public TipoDeItemResponseDto saveTipoDeItem(TipoDeItem tipoDeItem) {

        return objectMapperUtil.map(
                daoTipoDeItem.save(tipoDeItem),
                TipoDeItemResponseDto.class);
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
