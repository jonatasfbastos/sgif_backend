/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.usuario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ifba.usuario.model.Usuario;

/**
 *
 * @author vitor
 */
@Service
public interface IServiceUsuario {

    public abstract Usuario saveUsuario(Usuario usuario);

    public abstract void deleteUsuario(Usuario usuario);

    public abstract List<Usuario> getAllUsuarios();

    public Usuario findById(Long id);

    public Usuario findByLoginAndSenha(String login, String senha);

}
