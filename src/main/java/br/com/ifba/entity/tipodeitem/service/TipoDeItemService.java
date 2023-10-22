package br.com.ifba.entity.tipodeitem.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.entity.tipodeitem.model.TipoDeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
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

    /**
     * Atualiza um TipoDeItem na base de dados e retorna um objeto DTO com os dados resumidos do TipoDeItem atualizado.
     *
     * @param tipoDeItem - O TipoDeItem que será atualizado na base de dados.
     * @return um objeto DTO com os dados resumidos do TipoDeItem atualizado.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public TipoDeItemResponseDto updateTipoDeItem(TipoDeItem tipoDeItem) {
        daoTipoDeItem.findById(tipoDeItem.getId())
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        return objectMapperUtil.map(
                daoTipoDeItem.save(tipoDeItem),
                TipoDeItemResponseDto.class);
    }


   /**
     * Deleta um TipoDeItem.
     *
     * @param ID - O id a ser deletado.
     * @return objeto DTO com os dados do TipoDeItem deletado.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public TipoDeItemResponseDto deleteTipoDeItem(UUID id) {
        return this.daoTipoDeItem.findById(id)
                .map(tipoDeItem -> {
                    daoTipoDeItem.delete(tipoDeItem);
                    return objectMapperUtil.map(tipoDeItem, TipoDeItemResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * Obtém uma lista de todos os TiposDeItem como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os TiposDeItem.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public List<TipoDeItemResponseDto> getAllTiposDeItem() {
        return objectMapperUtil.mapAll(
                this.daoTipoDeItem.findAll(),
                TipoDeItemResponseDto.class);
    }
    
}
