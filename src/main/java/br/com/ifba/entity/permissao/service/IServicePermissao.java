package br.com.ifba.entity.permissao.service;

import br.com.ifba.entity.permissao.model.Permissao;

import java.util.List;

public interface IServicePermissao {

    Permissao savePermissao(Permissao permissao);
    String deletePermissao(Long id);
    Permissao updatePermissao(Permissao permissao);
    List<Permissao> getAllPermissoes();
    List<Permissao> getAllByPerfilId(Long id);
    List<Permissao> getAllByLinkId(Long id);

}