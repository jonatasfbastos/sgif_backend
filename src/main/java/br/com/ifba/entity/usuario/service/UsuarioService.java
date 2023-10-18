package br.com.ifba.entity.usuario.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import br.com.ifba.entity.usuario.dao.IDaoUsuario;
import br.com.ifba.entity.usuario.dto.UsuarioResponseDto;
import br.com.ifba.entity.usuario.dto.UsuarioSimpleResponseDto;
import br.com.ifba.entity.usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.support.StringUtil;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @author Andesson Reis
 * Desde V1.0.1
 */
@Service
public class UsuarioService implements IUsuarioService {
    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoUsuario daoUsuario;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    /**
     * Salva um Usuario na base de dados e retorna um objeto DTO com os dados
     * resumidos do usuario salvo.
     *
     * @param usuario - O usuario que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do usuario salvo.
     */

   @Override
    public UsuarioSimpleResponseDto saveUsuario(@Valid Usuario usuario) {

        usuario.setPassword(StringUtil.toMD5(usuario.getPassword()));

        return objectMapperUtil.map(
            daoUsuario.save(usuario),
            UsuarioSimpleResponseDto.class
        );
    }


    /**
     * Deleta um Usuario.
     *
     * @param id O ID do usuario a ser deletado.
     * @return objeto DTO com os dados do usuario deletado.
     */
    @Override
    public UsuarioSimpleResponseDto deleteUsuario(Long id) {
    
        Usuario usuario = daoUsuario.findById(id)
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    
        daoUsuario.delete(usuario);
    
        return objectMapperUtil.map(usuario, UsuarioSimpleResponseDto.class);
    }
    

    /**
     * Obtém uma lista de todos os usuários como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os usuários.
     */
    @Override
    public List<UsuarioSimpleResponseDto> getAllUsuarios() {
    
        return daoUsuario.findAll().stream()
                .map(objectMapperUtil.mapFn(UsuarioSimpleResponseDto.class))
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
            .map(objectMapperUtil.mapFn(UsuarioResponseDto.class))
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
                .map(objectMapperUtil.mapFn(UsuarioResponseDto.class))
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    
    }    

}
