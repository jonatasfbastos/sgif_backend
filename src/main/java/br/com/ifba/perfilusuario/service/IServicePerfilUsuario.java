/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.perfilusuario.service;

import java.util.List;

import br.com.ifba.perfilusuario.model.PerfilUsuario;

/**
 *
 * @author Igor Lopes e Eduarda
 */
public interface IServicePerfilUsuario {

    PerfilUsuario savePerfilUsuario(PerfilUsuario perfilDeUsuario);
    PerfilUsuario updatePerfilDeUsuario(PerfilUsuario perfilDeUsuario);
    void deletePerfilUsuario(PerfilUsuario perfilDeUsuario);
    List<PerfilUsuario> getAllPerfilUsuario();
    List<PerfilUsuario> findByNome(String name);
    List<PerfilUsuario> findPerfisByPermissaoId(Long id);

}
