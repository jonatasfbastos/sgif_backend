package br.com.ifba.permissaolink.service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.support.StringUtil;
import br.com.ifba.permissaolink.dao.IDaoPermissaoLink;
import br.com.ifba.permissaolink.model.PermissaoLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicePermissaoLink implements IServicePermissaoLink {

    private final static String CAMPO_VAZIO = "Há campo vazio, preencha e tente novamente.";
    private final static String LINK_NAO_EXISTE = "O link informado não existe.";
    private final static String LINK_EXISTE = "O link informado já existe.";
    private final static String LINK_DELETADO = "Link deletado com sucesso.";
    private final static String HA_PERMISSAO_ASSOCIADA = "Não foi possível deletar o link, há permissão associada a este link.";

    @Autowired
    private IDaoPermissaoLink daoLink;

    private boolean validarCampos(PermissaoLink permissaoLink) {
        if (StringUtil.getInstance().isNullOrEmpty(permissaoLink.getNome())) {
            return true;
        }
        return StringUtil.getInstance().isNullOrEmpty(permissaoLink.getUrl());
    }

    @Override
    public PermissaoLink saveLink(PermissaoLink permissaoLink) {
        if (validarCampos(permissaoLink)) {
            throw new BusinessException(CAMPO_VAZIO);
        }
        if (daoLink.existsByUrl(permissaoLink.getUrl())) {
            throw new BusinessException(LINK_EXISTE);
        }
        return daoLink.save(permissaoLink);
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