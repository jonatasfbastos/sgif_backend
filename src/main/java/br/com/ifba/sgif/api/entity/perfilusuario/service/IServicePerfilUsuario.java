package br.com.ifba.sgif.api.entity.perfilusuario.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.perfilusuario.dto.PerfilUsuarioResponseDto;
import br.com.ifba.sgif.api.entity.perfilusuario.model.PerfilUsuario;

import org.springframework.stereotype.Service;

/**
 * Interface que define os serviços relacionados a perfis de usuários (Response DTOs).
 *
 * @author Andesson Reis
 * @since V1.0.1
 */
@Service
public interface IServicePerfilUsuario {

    /**
     * Salva um perfil de usuário (Response DTO) na base de dados.
     *
     * @param perfilUsuario O perfil de usuário (Response DTO) a ser salvo.
     * @return O perfil de usuário salvo.
     */
    PerfilUsuarioResponseDto savePerfilUsuario(PerfilUsuario perfilUsuario);

    /**
     * Atualiza um perfil de usuário (Response DTO) na base de dados.
     *
     * @param perfilUsuario O perfil de usuário a ser atualizado.
     * @return O perfil de usuário (Response DTO) atualizado.
     */
    PerfilUsuarioResponseDto updatePerfilDeUsuario(PerfilUsuario perfilUsuario);

    /**
     * Deleta um perfil de usuário (Response DTO) da base de dados.
     *
     * @param Id id do perfil de usuário a ser deletado.
     */
    PerfilUsuarioResponseDto deletePerfilUsuario(UUID ID);

    /**
     * Obtém uma lista de todos os perfis de usuário (Response DTO).
     *
     * @return Uma lista de perfis de usuário (Response DTO).
     */
    List<PerfilUsuarioResponseDto> getAllPerfilUsuario();

    /**
     * Encontra perfis de usuário (Response DTO) pelo nome.
     *
     * @param name O nome a ser pesquisado.
     * @return Uma lista de perfis de usuário (Response DTO) com o nome especificado.
     */
    List<PerfilUsuarioResponseDto> findByNome(String name);

    /**
     * Encontra perfis de usuário (Response DTO) por ID de permissão.
     *
     * @param id O ID da permissão a ser pesquisada.
     * @return Uma lista de perfis de usuário (Response DTO) com a permissão especificada.
     */
    List<PerfilUsuarioResponseDto> findPerfisByPermissaoId(UUID id);
}
