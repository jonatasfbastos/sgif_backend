package br.com.ifba.sgif.api.entity.tipodeitem.service;

import java.util.List;

import br.com.ifba.sgif.api.entity.tipodeitem.model.TipoDeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.sgif.api.infrastructure.exception.BusinessException;
import br.com.ifba.sgif.api.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.sgif.api.entity.tipodeitem.dao.IDaoTipoItem;
import br.com.ifba.sgif.api.entity.tipodeitem.dto.TipoDeItemResponseDto;

/**
 * Service que fornece operações relacionadas a TipoDeItem
 *
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
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
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Salva um TipoDeItem na base de dados e retorna um objeto DTO com os dados resumidos do TipoDeItem salvo.
     *
     * @param tipoDeItem - O TipoDeItem que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do TipoDeItem salvo.
     */
    @Override
    public TipoDeItemResponseDto saveTipoDeItem(TipoDeItem tipoDeItem) {

        return objectMapperUtil.map(
                daoTipoDeItem.save(tipoDeItem),
                TipoDeItemResponseDto.class);
    }

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Atualiza um TipoDeItem na base de dados e retorna um objeto DTO com os dados resumidos do TipoDeItem atualizado.
     *
     * @param tipoDeItem - O TipoDeItem que será atualizado na base de dados.
     * @return um objeto DTO com os dados resumidos do TipoDeItem atualizado.
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
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Deleta um TipoDeItem.
     *
     * @param ID - O id a ser deletado.
     * @return objeto DTO com os dados do TipoDeItem deletado.
     */
    @Override
    public TipoDeItemResponseDto deleteTipoDeItem(Long id) {
        return this.daoTipoDeItem.findById(id)
                .map(tipoDeItem -> {
                    daoTipoDeItem.delete(tipoDeItem);
                    return objectMapperUtil.map(tipoDeItem, TipoDeItemResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Obtém uma lista de todos os TiposDeItem como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os TiposDeItem.
     */
    @Override
    public List<TipoDeItemResponseDto> getAllTiposDeItem() {
        return objectMapperUtil.mapAll(
                this.daoTipoDeItem.findAll(),
                TipoDeItemResponseDto.class);
    }
}
