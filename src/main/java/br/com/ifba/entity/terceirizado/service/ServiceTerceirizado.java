package br.com.ifba.entity.terceirizado.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.ifba.entity.terceirizado.model.Terceirizado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.entity.terceirizado.dao.IDaoTerceirizado;
import br.com.ifba.entity.terceirizado.dto.TerceirizadoResponseDto;

/**
 * Service que fornece operações relacionadas a Terceirizado
 *
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
 */

@Service
public class ServiceTerceirizado implements IServiceTerceirizado {

    // =========================================================== //
    // ======================= [ ATRIBUTOS ] ===================== //
    // =========================================================== //

    @Autowired
    private IDaoTerceirizado terceirizadoDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;
    
    
    // =========================================================== //
    // ========================= [ MÉTODOS ] ===================== //
    // =========================================================== //
    
    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Salva um Terceirizado na base de dados e retorna um objeto DTO com os dados resumidos do Terceirizado salvo.
     *
     * @param terceirizado - O Terceirizado que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do Terceirizado salvo.
     */
    @Override
    public TerceirizadoResponseDto saveTerceirizado(Terceirizado terceirizado) {

        return objectMapperUtil.map(
                terceirizadoDao.save(terceirizado),
                TerceirizadoResponseDto.class);
    }

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Atualiza um Terceirizado na base de dados e retorna um objeto DTO com os dados resumidos do Terceirizado atualizado.
     *
     * @param terceirizado - O Terceirizado que será atualizado na base de dados.
     * @return um objeto DTO com os dados resumidos do Terceirizado atualizado.
     */
    @Override
    public TerceirizadoResponseDto updateTerceirizado(Terceirizado terceirizado) {
          return Optional.of(terceirizado)
                        .filter(terc -> this.terceirizadoDao.existsById(terceirizado.getId()))
                        .map(terc -> objectMapperUtil.map(this.terceirizadoDao.save(terc), TerceirizadoResponseDto.class))
                        .orElseThrow(
                                () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                        );
    }

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Deleta um Terceirizado.
     *
     * @param Id - O ID do Terceirizado a ser deletado.
     * @return objeto DTO com os dados do Terceirizado deletado.
     */
    @Override
    public TerceirizadoResponseDto deleteTerceirizado(UUID id) {
        return this.terceirizadoDao.findById(id)
                .map(terc -> {
                    terceirizadoDao.delete(terc);
                    return objectMapperUtil.map(terc, TerceirizadoResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Obtém uma lista de todos os Terceirizados como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os Terceirizados.
     */
    @Override
    public List<TerceirizadoResponseDto> getAllTerceirizados() {
        return objectMapperUtil.mapAll(
                this.terceirizadoDao.findAll(),
                TerceirizadoResponseDto.class);
    }
}
