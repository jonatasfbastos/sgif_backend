package br.com.ifba.sgif.api.entity.permissaolink.service;

import br.com.ifba.sgif.api.infrastructure.exception.BusinessException;
import br.com.ifba.sgif.api.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.sgif.api.entity.permissaolink.dao.IDaoPermissaoLink;
import br.com.ifba.sgif.api.entity.permissaolink.dto.PermissaoLinkResponseDto;
import br.com.ifba.sgif.api.entity.permissaolink.model.PermissaoLink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

/**
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
 */
@Service
public class ServicePermissaoLink implements IServicePermissaoLink {

    // =========================================================== //
    // ====================== [ ATRIBUTOS ] ====================== //
    // =========================================================== //

    @Autowired
    private IDaoPermissaoLink daoLink;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // ====================== [ MÉTODOS ] ======================== //
    // =========================================================== //

    /**
     * Salva um PermissaoLink na base de dados e retorna um objeto DTO com os dados
     * resumidos do PermissaoLink salvo.
     *
     * @param permissaoLink - O PermissaoLink que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do PermissaoLink salvo.
     */
    @Override
    public PermissaoLinkResponseDto saveLink(@Valid PermissaoLink permissaoLink) {
        // Verifica se já existe uma PermissaoLink com a mesma URL na base de dados
        if (daoLink.existsByUrl(permissaoLink.getUrl())) {
            throw new BusinessException(BusinessExceptionMessage.ATTRIBUTE_VALUE_ALREADY_EXISTS.getMensagem());
        }

        return objectMapperUtil.map(
                daoLink.save(permissaoLink),
                PermissaoLinkResponseDto.class);
    }

    /**
     * Deleta um PermissaoLink pelo ID.
     *
     * @param id - O ID do PermissaoLink a ser deletado.
     * @return um objeto DTO com os dados do PermissaoLink deletado.
     * @throws BusinessException se o PermissaoLink não for encontrado ou se estiver
     *                           associado a Permissoes.
     * 
     */
    @Override
    public PermissaoLinkResponseDto deleteLink(UUID id) {
        // Busca o PermissaoLink pelo ID ou lança uma exceção se não for encontrado
        PermissaoLink permissaoLink = daoLink.findById(id)
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        // Verifica se o PermissaoLink está associado a Permissoes
        if (!permissaoLink.getPermissoes().isEmpty()) {
            throw new BusinessException(BusinessExceptionMessage.ATTRIBUTE_VALUE_ALREADY_EXISTS.getMensagem());
        }

        daoLink.delete(permissaoLink);

        return objectMapperUtil.map(
                permissaoLink,
                PermissaoLinkResponseDto.class);
    }

    /**
     * Atualiza um PermissaoLink na base de dados.
     *
     * @param permissaoLink - O PermissaoLink a ser atualizado.
     * @return um objeto DTO com os dados do PermissaoLink atualizado.
     * @throws BusinessException se o PermissaoLink com o ID especificado não for
     *                           encontrado.
     */
    @Override
    public PermissaoLinkResponseDto updateLink(PermissaoLink permissaoLink) {
        // Busca o PermissaoLink pelo ID ou lança uma exceção se não for encontrado
        daoLink.findById(permissaoLink.getId())
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        return objectMapperUtil.map(
                daoLink.save(permissaoLink),
                PermissaoLinkResponseDto.class);
    }

    /**
     * Obtém uma lista de todos os PermissaoLinks como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os PermissaoLinks.
     */
    @Override
    public List<PermissaoLinkResponseDto> getAllLinks() {
        return objectMapperUtil.mapAll(
                this.daoLink.findAll(),
                PermissaoLinkResponseDto.class);
    }

    /**
     * Obtém uma lista de PermissaoLinks por ID da Permissao associada como objetos DTO.
     *
     * @param id - O ID da Permissao associada.
     * @return uma lista de objetos DTO representando os PermissaoLinks associados à
     *         Permissao.
     */
    @Override
    public List<PermissaoLinkResponseDto> getAllByPermissaoId(UUID id) {
        return objectMapperUtil.mapAll(
                this.daoLink.findByPermissoesId(id),
                PermissaoLinkResponseDto.class);
    }

}