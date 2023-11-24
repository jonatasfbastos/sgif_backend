package br.com.ifba.sgif.api.entity.usuario.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.perfilusuario.dao.IDaoPerfilUsuario;
import br.com.ifba.sgif.api.entity.usuario.dao.IDaoUsuario;
import br.com.ifba.sgif.api.entity.usuario.dto.UsuarioResponseDto;
import br.com.ifba.sgif.api.entity.usuario.dto.UsuarioSimpleResponseDto;
import br.com.ifba.sgif.api.entity.usuario.model.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.sgif.api.infrastructure.exception.BusinessException;
import br.com.ifba.sgif.api.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author vitor
 * @since V1.0.1
 * Editado por Andesson Reis
 */
@Slf4j
@Service
public class UsuarioService implements IUsuarioService {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoUsuario daoUsuario;

    @Autowired
    private IDaoPerfilUsuario perfilUsuarioDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

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
    @Transactional
    @Override
    public UsuarioSimpleResponseDto saveUsuario(final Usuario usuario) {

        log.info("Salvando usuário {}", usuario.toString());

        perfilUsuarioDao.save(usuario.getPerfilUsuario());

        return objectMapperUtil.map(
                daoUsuario.save(usuario),
                new UsuarioSimpleResponseDto()
        );
    }

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * <p>
     * Deleta um Usuario.
     *
     * @param id O ID do usuario a ser deletado.
     * @return objeto DTO com os dados do usuario deletado.
     */
    @Override
    public UsuarioSimpleResponseDto deleteUsuario(UUID id) {

        return this.daoUsuario.findById(id)
                .map(user -> {
                    daoUsuario.delete(user);
                    return objectMapperUtil.map(user, UsuarioSimpleResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

    }

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * <p>
     * Obtém uma lista de todos os usuários como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os usuários.
     */
    @Override
    public List<UsuarioSimpleResponseDto> getAllUsuarios() {

        return objectMapperUtil.mapAll(
                this.daoUsuario.findAll(),
                UsuarioSimpleResponseDto.class);
    }

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * <p>
     * Encontra um usuário pelo ID.
     *
     * @param id - O ID do usuário a ser encontrado.
     * @return um objeto DTO com os dados resumidos do usuário encontrado.
     */
    @Override
    public UsuarioResponseDto findById(UUID id) {

        return daoUsuario.findById(id)
                .map(objectMapperUtil.mapFn(UsuarioResponseDto.class))
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

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
    @Override
    public UsuarioResponseDto findByLoginAndSenha(String login, String senha) {

        return daoUsuario.findByLoginAndSenha(login, senha)
                .map(objectMapperUtil.mapFn(UsuarioResponseDto.class))
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

    }
}
