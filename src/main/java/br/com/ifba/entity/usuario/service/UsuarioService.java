package br.com.ifba.entity.usuario.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.ifba.entity.usuario.dao.IDaoUsuario;
import br.com.ifba.entity.usuario.dto.UsuarioRequestDto;
import br.com.ifba.entity.usuario.dto.UsuarioResponseDto;
import br.com.ifba.entity.usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.support.StringUtil;

/**
 * @author Andesson Reis
 *         Desde V1.0.1
 */
@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IDaoUsuario daoUsuario;

    /**
     * Salva um Usuario na base de dados e retorna um objeto DTO com os dados
     * resumidos do usuario salvo.
     *
     * @param usuario - O usuario que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do usuario salvo.
     */

    @Override
    public UsuarioResponseDto saveUsuario(@Valid Usuario usuario) {
        usuario.setPassword(StringUtil.toMD5(usuario.getPassword()));

        // Verifica se o login(username) do usuário já existe no banco de dados
        Optional<Usuario> usuarioExistente = daoUsuario.findByLogin(usuario.getLogin());

        if (usuarioExistente.isPresent()) {
            // O usuário já existe
            if (usuario.getId() != null) {
                // O usuário já existe e está sendo atualizado
                throw new BusinessException(BusinessExceptionMessage.LOGIN_ALREADY_IN_USE.getMensagem());
            } else {
                // O usuário já existe e está sendo inserido
                throw new BusinessException("O login já está em uso.");
            }
        }
        //Todo: Provavelente adicionar mais validações

        return usuario.toResponseDto();
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
