package br.com.ifba.entity.permissaolink.service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.support.StringUtil;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.entity.permissaolink.dao.IDaoPermissaoLink;
import br.com.ifba.entity.permissaolink.dto.PermissaoLinkResponseDto;
import br.com.ifba.entity.permissaolink.model.PermissaoLink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

/**
 * @author Andesson Reis
 * Desde V1.0.1
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

    private boolean validarCampos(PermissaoLink permissaoLink) {
        if (StringUtil.getInstance().isNullOrEmpty(permissaoLink.getNome())) {
            return true;
        }
        return StringUtil.getInstance().isNullOrEmpty(permissaoLink.getUrl());
    }

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
     * @throws BusinessException se o PermissaoLink não for encontrado ou se estiver  associado a Permissoes.
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

    @Override
    public PermissaoLink updateLink(PermissaoLink permissaoLink) {
        if (validarCampos(permissaoLink)) {
            throw new BusinessException(CAMPO_VAZIO);
        }
        return daoLink.save(permissaoLink);
    }

    @Override
    public List<PermissaoLink> getAllLinks() {
        return daoLink.findAll();
    }

    @Override
    public List<PermissaoLink> getAllByPermissaoId(Long id) {
        return daoLink.findByPermissoesId(id);
    }

}