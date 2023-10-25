package br.com.ifba.entity.tipoturma.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.entity.tipoturma.dao.IDaoTipoTurma;
import br.com.ifba.entity.tipoturma.dto.TipoTurmaResponseDto;
import br.com.ifba.entity.tipoturma.model.TipoTurma;

/**
 * Service que fornece operações relacionadas a Tipos de Turma.
 *
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
 */
@Service
public class ServiceTipoTurma implements IServiceTipoTurma{

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

     @Autowired
    private IDaoTipoTurma tipoTurmaDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;
    
    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //
    
    /**
     * Salva um Tipo de Turma na base de dados e retorna um objeto DTO com os dados resumidos do Tipo de Turma salvo.
     *
     * @param tipoTurma - O Tipo de Turma que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do Tipo de Turma salvo.
     * 
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public TipoTurmaResponseDto saveTipoTurma(TipoTurma tipoTurma) {

        return Optional.of(tipoTurma)
                .filter(tipo -> !this.tipoTurmaDao.existsByNome(tipo.getNome()))
                .map(tipo -> objectMapperUtil.map(this.tipoTurmaDao.save(tipo), TipoTurmaResponseDto.class))
                .orElseThrow(() -> new BusinessException(
                        BusinessExceptionMessage.ATTRIBUTE_VALUE_ALREADY_EXISTS.getMensagemValorJaExiste("Nome"))
                );


    }

    /**
     * Atualiza um Tipo de Turma na base de dados e retorna um objeto DTO com os dados resumidos do Tipo de Turma atualizado.
     *
     * @param tipoTurma - O Tipo de Turma que será atualizado na base de dados.
     * @return um objeto DTO com os dados resumidos do Tipo de Turma atualizado.
     * @author Andesson Reis
     * @since V1.0.1
     */    
    @Override
    public TipoTurmaResponseDto updateTipoTurma(TipoTurma tipoturma) {
 
        return Optional.of(tipoturma)
                        .filter(tipo -> this.tipoTurmaDao.existsById(tipoturma.getId()))
                        .map(tipo -> objectMapperUtil.map(this.tipoTurmaDao.save(tipo), TipoTurmaResponseDto.class))
                        .orElseThrow(
                                () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                        );
    }

    /**
     * Deleta um Tipo de Turma com base no ID.
     *
     * @param id - O ID do Tipo de Turma a ser deletado.
     * @return um objeto DTO com os dados do Tipo de Turma deletado.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public TipoTurmaResponseDto deleteTipoTurma(UUID id) {

        return this.tipoTurmaDao.findById(id)
                .map(tipoTurma -> {
                    tipoTurmaDao.delete(tipoTurma);
                    return objectMapperUtil.map(tipoTurma, TipoTurmaResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * Obtém uma lista de todos os Tipos de Turma como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os Tipos de Turma.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public List<TipoTurmaResponseDto> getAllTipoTurma() {
        
        return objectMapperUtil.mapAll(
                this.tipoTurmaDao.findAll(),
                TipoTurmaResponseDto.class);
    }
}
