/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.entity.usuario.service;

import java.util.List;

import br.com.ifba.entity.usuario.dto.UsuarioResponseDto;
import br.com.ifba.entity.usuario.model.Usuario;
import org.springframework.stereotype.Service;

/**
 *
 * @author vitor
 */
@Service
public interface IUsuarioService {

    public abstract Usuario saveUsuario(Usuario usuario);

    public abstract void deleteUsuario(Usuario usuario);
    
    public abstract List<UsuarioResponseDto> getAllUsuariosDto();

    //public abstract List<Usuario> getAllUsuarios();

    public Usuario findById(Long id);

    public Usuario findByLoginAndSenha(String login, String senha);

}
