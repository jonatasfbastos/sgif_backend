/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.entity.perfilusuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.entity.perfilusuario.dao.IDaoPerfilUsuario;
import br.com.ifba.entity.perfilusuario.model.PerfilUsuario;

/**
 *
 * @author Igor Lopes e Eduarda
 */
@Service
public class ServicePerfilUsuario implements IServicePerfilUsuario {

    // CONSTANTES

    // mensagem de erro se o Usuario for null;
    public final static String USUARIO_NULL = "Perfil de Usuário null";

    // mensagem de erro se o Usuario já existir;
    public final static String USUARIO_EXISTE = "O Perfil de Usuário já existe,";

    // mensagem de erro se o Usuario não existir no banco;
    public final static String USUARIO_NAO_EXISTE = "O Perfil de Usuário não existe na base de dados";

    // mensagem de erro se o Usuario for inválido;
    public final static String USUARIO_INVALIDO = "Perfil de Usuário inválido";

    // OBJETO
    @Autowired
    private IDaoPerfilUsuario daoPerfilDeUsuario;

    @Override
    public PerfilUsuario savePerfilUsuario(PerfilUsuario perfilDeUsuario) {
        if (perfilDeUsuario == null) {
            throw new BusinessException(USUARIO_NULL);
        } else {
            return daoPerfilDeUsuario.save(perfilDeUsuario);
        }
    }

    @Override
    public PerfilUsuario updatePerfilDeUsuario(PerfilUsuario perfilDeUsuario) {
        if (perfilDeUsuario == null) {
            throw new BusinessException(USUARIO_NULL);
        } else if (daoPerfilDeUsuario.findById(perfilDeUsuario.getId()) == null) {
            throw new BusinessException(USUARIO_NAO_EXISTE);
        } else {
            return daoPerfilDeUsuario.save(perfilDeUsuario);
        }
    }

    @Override
    public void deletePerfilUsuario(PerfilUsuario perfilDeUsuario) {
        if (perfilDeUsuario == null) {
            throw new BusinessException(USUARIO_NULL);
        } else {
            this.daoPerfilDeUsuario.delete(perfilDeUsuario);
            return;
        }
    }

    @Override
    public List<PerfilUsuario> getAllPerfilUsuario() {
        return (List<PerfilUsuario>)this.daoPerfilDeUsuario.findAll();
    }

    @Override
    public List<PerfilUsuario> findByNome(String name) {
        if (name == null) {
            throw new BusinessException("Nome null");
        } else if (name.isEmpty()) {
            throw new BusinessException("Nome vazio");
        } else {
            return daoPerfilDeUsuario.findByNome(name);
        }
    }

    @Override
    public List<PerfilUsuario> findPerfisByPermissaoId(Long id) {
        return daoPerfilDeUsuario.findByPermissoesId(id);
    }

}
