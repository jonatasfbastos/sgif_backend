package br.com.ifba.entity.usuario.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import br.com.ifba.entity.formulario.model.Formulario;
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
 * Desde V1.0.1
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


    /**
     * Deleta um Usuario.
     *
     * @param id O ID do usuario a ser deletado.
     * @return objeto DTO com os dados do usuario deletado.
     */
    @Override
    public UsuarioResponseDto deleteUsuario(Long id) {
       
        Usuario usuario = daoUsuario.findById(id)
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        daoUsuario.delete(usuario);

        return usuario.toResponseDto();
    }


    /**
     * Obtém uma lista de todos os usuários como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os usuários.
     */
    @Override
    public List<UsuarioResponseDto> getAllUsuarios() {
        
    return this.daoUsuario.findAll().stream()
            .map(Usuario::toResponseDto)
            .collect(Collectors.toList());
    }

    
    /**
     * Encontra um usuário pelo ID.
     *
     * @param id - O ID do usuário a ser encontrado.
     * @return um objeto DTO com os dados resumidos do usuário encontrado.
     */
    @Override
    public UsuarioResponseDto findById(Long id) {
        return daoUsuario.findById(id)
            .map(Usuario::toResponseDto)
            .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }
    

    /**
     * Encontra um usuário pelo login e senha.
     *
     * @param login - O login do usuário.
     * @param senha - A senha do usuário.
     * @return um objeto DTO com os dados resumidos do usuário encontrado.
     */
    @Override
    public UsuarioResponseDto findByLoginAndSenha(String login, String senha) {
        
        return daoUsuario.findByLoginAndSenha(login, senha)
                .map(Usuario::toResponseDto)
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

    }

}
