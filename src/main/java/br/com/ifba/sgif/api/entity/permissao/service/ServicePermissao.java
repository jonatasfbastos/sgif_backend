package br.com.ifba.sgif.api.entity.permissao.service;

import br.com.ifba.sgif.api.entity.permissao.dao.IDaoPermissao;
import br.com.ifba.sgif.api.entity.permissao.dto.PermissaoResponseDto;
import br.com.ifba.sgif.api.entity.permissao.model.Permissao;
import br.com.ifba.sgif.api.infrastructure.exception.BusinessException;
import br.com.ifba.sgif.api.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço para manipulação de permissões.
 * 
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
 */
@Service
public class ServicePermissao implements IServicePermissao {

    // =========================================================== //
    // ======================= [ ATRIBUTOS ] ===================== //
    // =========================================================== //

    @Autowired
    private IDaoPermissao daoPermissao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // ======================== [ MÉTODOS ] ====================== //
    // =========================================================== //

    /**
     * Salva uma permissão na base de dados e retorna um objeto DTO com os dados da permissão salva.
     *
     * @param permissao - A permissão que será salva na base de dados.
     * @return um objeto DTO com os dados da permissão salva.
     */
    @Override
    public PermissaoResponseDto savePermissao(Permissao permissao) {
        return objectMapperUtil.map(
                daoPermissao.save(permissao),
                PermissaoResponseDto.class);
    }

    /**
     * Deleta uma permissão pelo ID.
     *
     * @param id - O ID da permissão a ser deletada.
     * @return um objeto DTO com os dados da permissão deletada.
     * @throws BusinessException se a permissão não for encontrada.
     */
    @Override
    public PermissaoResponseDto deletePermissao(Long id) {
        return this.daoPermissao.findById(id)
                .map(permissao -> {
                    daoPermissao.delete(permissao);
                    return objectMapperUtil.map(permissao, PermissaoResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * Atualiza uma permissão na base de dados.
     *
     * @param permissao - A permissão a ser atualizada.
     * @return um objeto DTO com os dados da permissão atualizada.
     * @throws BusinessException se a permissão com o ID especificado não for encontrada.
     */
    @Override
    public PermissaoResponseDto updatePermissao(Permissao permissao) {
        daoPermissao.findById(permissao.getId())
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        return objectMapperUtil.map(
                daoPermissao.save(permissao),
                PermissaoResponseDto.class);
    }

    /**
     * Obtém uma lista de todas as permissões como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as permissões.
     */
    @Override
    public List<PermissaoResponseDto> getAllPermissoes() {
        return objectMapperUtil.mapAll(
                this.daoPermissao.findAll(),
                PermissaoResponseDto.class);
    }

    /**
     * Obtém uma lista de permissões por ID do perfil associado como objetos DTO.
     *
     * @param id - O ID do perfil associado.
     * @return uma lista de objetos DTO representando as permissões associadas ao perfil.
     */
    @Override
    public List<PermissaoResponseDto> getAllByPerfilId(Long id) {
        return objectMapperUtil.mapAll(
                this.daoPermissao.findByPerfisId(id),
                PermissaoResponseDto.class);
    }

    /**
     * Obtém uma lista de permissões por ID do link associado como objetos DTO.
     *
     * @param id - O ID do link associado.
     * @return uma lista de objetos DTO representando as permissões associadas ao link.
     */
    @Override
    public List<PermissaoResponseDto> getAllByLinkId(Long id) {
        return objectMapperUtil.mapAll(
                this.daoPermissao.findByLinksId(id),
                PermissaoResponseDto.class);
    }
}
