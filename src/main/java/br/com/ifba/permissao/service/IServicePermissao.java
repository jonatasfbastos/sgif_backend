package br.com.ifba.permissao.service;

import br.com.ifba.permissao.model.Permissao;
import java.util.List;

public interface IServicePermissao {

    Permissao savePermissao(Permissao permissao);
    String deletePermissao(Long id);
    Permissao updatePermissao(Permissao permissao);
    List<Permissao> getAllPermissoes();
    List<Permissao> getAllByPerfilId(Long id);

}