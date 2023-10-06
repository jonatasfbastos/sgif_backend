package br.com.ifba.entity.usuario.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.usuario.model.Usuario;

public interface IDaoUsuario extends JpaRepository<Usuario, Long> {

    public abstract Optional<Usuario> findById(Long id);

    public abstract Optional<Usuario> findByLoginAndSenha(String login, String senha);
}
