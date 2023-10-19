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

import javax.validation.Valid;

/**
 * @author Andesson Reis
 *         Desde V1.0.1
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

    @Override
    public String deleteLink(Long id) {
        if (daoLink.existsById(id) == false) {
            throw new BusinessException(LINK_NAO_EXISTE);
        }
        if (daoLink.getReferenceById(id).getPermissoes().isEmpty() == false) {
            throw new BusinessException(HA_PERMISSAO_ASSOCIADA);
        }
        daoLink.deleteById(id);
        return LINK_DELETADO;
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