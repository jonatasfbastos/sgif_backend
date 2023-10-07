package br.com.ifba.entity.usuario.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.usuario.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface IDaoUsuario extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByLoginAndSenha(String login, String senha);
}
