package br.com.ifba.sgif.api.entity.usuario.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.usuario.dto.UsuarioResponseDto;
import br.com.ifba.sgif.api.entity.usuario.dto.UsuarioSimpleResponseDto;
import br.com.ifba.sgif.api.entity.usuario.model.Usuario;

import org.springframework.stereotype.Service;

/**
 *
 * @author vitor
 * @since V1.0.1
 * Editado por Andesson Reis
 */
@Service
public interface IUsuarioService {

  /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * <p>
     * Salva um Usuario na base de dados e retorna um objeto DTO com os dados
     * resumidos do usuario salvo.
     *
     * @param usuario - O usuario que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do usuario salvo.
     */
    UsuarioSimpleResponseDto saveUsuario(Usuario usuario);

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * <p>
     * Deleta um Usuario.
     *
     * @param id O ID do usuario a ser deletado.
     * @return objeto DTO com os dados do usuario deletado.
     */
    UsuarioSimpleResponseDto deleteUsuario(Long id);

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * <p>
     * Obtém uma lista de todos os usuários como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os usuários.
     */
    List<UsuarioResponseDto> getAllUsuarios();

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * <p>
     * Encontra um usuário pelo ID.
     *
     * @param id - O ID do usuário a ser encontrado.
     * @return um objeto DTO com os dados resumidos do usuário encontrado.
     */
    UsuarioResponseDto findById(Long id);

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * <p>
     * Encontra um usuário pelo login e senha.
     *
     * @param login - O login do usuário.
     * @param senha - A senha do usuário.
     * @return um objeto DTO com os dados resumidos do usuário encontrado.
     */
    UsuarioResponseDto findByLoginAndSenha(String login, String senha);
}
