package br.com.ifba.entity.usuario.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.usuario.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Andesson reis
 * Desde V1.0.1
 * 
 *Veja também: {@link br.com.ifba.entity.usuario.model.Usuario}
 */

@Repository
public interface IDaoUsuario extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findById(UUID id);
    Optional<Usuario> findByLoginAndSenha(String login, String senha);
    Optional<Usuario> findByLogin(String login);

    /**
     * Encontra um usuário pelo login passado por parâmetro.
     *
     * @author Giovane Neves
     * @since V1.0.1
     * @param login O login do usuário a ser buscado.
     * @return instância com dados do usuário encontrado.
     */
    @Query("select u from Usuario u where u.login = ?1")
    Usuario findUserByLogin(String login);
}
