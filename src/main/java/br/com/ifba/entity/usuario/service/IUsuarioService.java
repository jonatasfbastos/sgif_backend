package br.com.ifba.entity.usuario.service;

import java.util.List;

import br.com.ifba.entity.usuario.dto.UsuarioResponseDto;
import br.com.ifba.entity.usuario.model.Usuario;

import org.springframework.stereotype.Service;

/**
 *
 * @author Andesson Reis
 * Desde V1.0.1
 */
@Service
public interface IUsuarioService {

    /**
     * Salva um Usuario na base de dados e retorna um objeto DTO com os dados resumidos do usuario salvo.
     *
     * @param usuario - O Usuario que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do usuario salvo.
     */
    UsuarioResponseDto saveUsuario(Usuario usuario);

      /**
     * Deleta um Usuario.
     *
     * @param id O ID do usuario a ser deletado.
     * @return objeto DTO com os dados do usuario deletado.
     */
    UsuarioResponseDto deleteUsuario(Long id);

    /**
     * Obtém uma lista de todos os usuários como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os usuários.
     */
    List<UsuarioResponseDto> getAllUsuarios();

    /**
     * Encontra um usuário pelo ID.
     *
     * @param id - O ID do usuário a ser encontrado.
     * @return um objeto DTO com os dados resumidos do usuário encontrado.
     */
    UsuarioResponseDto findById(Long id);

    /**
     * Encontra um usuário pelo login e senha.
     *
     * @param login - O login do usuário.
     * @param senha - A senha do usuário.
     * @return um objeto DTO com os dados resumidos do usuário encontrado.
     */
    UsuarioResponseDto findByLoginAndSenha(String login, String senha);
}
