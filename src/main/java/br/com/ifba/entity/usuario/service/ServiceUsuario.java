/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.entity.usuario.service;

import java.util.List;
import java.util.Optional;

import br.com.ifba.entity.usuario.dao.IDaoUsuario;
import br.com.ifba.entity.usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.support.StringUtil;

/**
 *
 * @author vitor
 */
@Service
public class ServiceUsuario implements IServiceUsuario {

    // OBJETO
    @Autowired
    private IDaoUsuario daoUsuario;

    // CONSTANTES

    // mensagem de erro se o Usuario for null;
    public final static String USUARIO_NULL = "Usuário null";

    // mensagem de erro se o Usuario já existir;
    public final static String USUARIO_EXISTE = "O Usuário já existe,";

    // mensagem de erro se o Usuario não existir no banco;
    public final static String USUARIO_NAO_EXISTE = "O Usuário não existe na base de dados";

    // mensagem de erro se o Usuario for inválido;
    public final static String USUARIO_INVALIDO = "Usuário inválido";

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new BusinessException(USUARIO_NULL);
        }

        // O usuario já existe e está atualizando o usuário
        Long id = usuario.getId();
        if (id != null) {
            Usuario oldUser = this.findById(usuario.getId());
            System.out.println("O usuario está sendo atualizado " + usuario.getId());
            // Busca o usuário salvo no banco para atualizar a senha somente se mudar

            // Verifica se a senha foi atualizada
            if (oldUser.getSenha() != StringUtil.toMD5(usuario.getSenha())) {
                usuario.setSenha(StringUtil.toMD5(usuario.getSenha()));
            }
        } else {
            // O usuario está sendo inserido
            System.out.println("O usuario está sendo inserido");
            usuario.setSenha(StringUtil.toMD5(usuario.getSenha()));
        }

        return daoUsuario.save(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new BusinessException(USUARIO_NULL);
        } else {
            this.daoUsuario.delete(usuario);
            return;
        }
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return (List<Usuario>) this.daoUsuario.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        Optional<Usuario> user = daoUsuario.findById(id);
        return user.isPresent() ? user.get() : null;
    }

    @Override
    public Usuario findByLoginAndSenha(String login, String senha) {
        Optional<Usuario> user = daoUsuario.findByLoginAndSenha(login, senha);
        return user.isPresent() ? user.get() : null;
    }

}
