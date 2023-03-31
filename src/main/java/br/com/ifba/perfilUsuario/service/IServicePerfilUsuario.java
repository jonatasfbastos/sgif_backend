/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.perfilUsuario.service;

import java.util.List;

import br.com.ifba.perfilUsuario.model.PerfilUsuario;

/**
 *
 * @author Igor Lopes e Eduarda
 */
public interface IServicePerfilUsuario {
    public abstract PerfilUsuario savePerfilUsuario(PerfilUsuario perfilDeUsuario);

    public abstract PerfilUsuario updatePerfilDeUsuario(PerfilUsuario perfilDeUsuario);

    public abstract void deletePerfilUsuario(PerfilUsuario perfilDeUsuario);

    public abstract List<PerfilUsuario> getAllPerfilUsuario();

    public List<PerfilUsuario> findByNome(String name);
}
