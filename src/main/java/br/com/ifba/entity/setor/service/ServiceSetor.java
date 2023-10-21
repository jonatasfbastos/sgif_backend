package br.com.ifba.entity.setor.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import br.com.ifba.entity.setor.dao.IDaoSetor;
import br.com.ifba.entity.setor.dto.SetorResponseDto;
import br.com.ifba.entity.setor.model.Setor;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Everton.
 * @Editado por Andesson Reis
 * @since V1.0.1
 * 
 * Service que fornece operações relacionadas a Setor
 * 
 * Esta classe contém métodos para criar, atualizar, excluir e recuperar
 * informações de setor.
 */
@Service
public class ServiceSetor implements IServiceSetor {

    // =========================================================== //
    // ======================= [ ATRIBUTOS ] ===================== //
    // =========================================================== //

    @Autowired
    private IDaoSetor daoSetor;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // ========================= [ MÉTODOS ] ===================== //
    // =========================================================== //

    /**
     * 
     * @author Andesson Reis
     * @since V1.0.1
     * 
     * Salva um setor na base de dados e retorna um objeto DTO com os dados
     * do setor salvo.
     *
     * @param setor - O setor que será salvo na base de dados.
     * @return um objeto DTO com os dados do setor salvo.
     */
    @Override
    public SetorResponseDto saveSetor(@Valid Setor setor) {
       
        return objectMapperUtil.map(
                daoSetor.save(setor),
                SetorResponseDto.class);
    }

    /**
     * 
     * @author Andesson Reis
     * @since V1.0.1
     * 
     * Atualiza um setor na base de dados.
     *
     * @param perfilUsuarioResponseDTO O setor a ser atualizado.
     *                                
     * @return O setor atualizado.
     */
    @Override
    public SetorResponseDto updateSetor(@Valid Setor setor) {

        daoSetor.findById(setor.getId())
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        return objectMapperUtil.map(
                daoSetor.save(setor),
                SetorResponseDto.class);
    }

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     *
     * Deleta um setor da base de dados.
     *
     * @param Id id do setor a ser deletado.
     */
    @Override
    public SetorResponseDto deleteSetor(UUID id) {
        
           return this.daoSetor.findById(id)
                .map(setor -> {
                    daoSetor.delete(setor);
                    return objectMapperUtil.map(setor, SetorResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }


    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     *
     * Obtém uma lista de todos os setores
     *
     * @return Uma lista setores.
     */
    @Override
    public List<SetorResponseDto> getAllSetor() {

        return objectMapperUtil.mapAll(
                this.daoSetor.findAll(),
                SetorResponseDto.class);
    }
}
