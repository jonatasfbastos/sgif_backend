package br.com.ifba.permissaolink.service;

import br.com.ifba.permissaolink.model.PermissaoLink;
import java.util.List;

public interface IServicePermissaoLink {

    PermissaoLink saveLink(PermissaoLink permissaoLink);
    String deleteLink(Long id);
    PermissaoLink updateLink(PermissaoLink permissaoLink);
    List<PermissaoLink> getAllLinks();
    List<PermissaoLink> getAllByPermissaoId(Long id);

}