package br.com.ifba.sgif.api.entity.perfilusuario.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.sgif.api.infrastructure.exception.BusinessException;
import br.com.ifba.sgif.api.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.sgif.api.entity.perfilusuario.dao.IDaoPerfilUsuario;
import br.com.ifba.sgif.api.entity.perfilusuario.dto.PerfilUsuarioResponseDto;
import br.com.ifba.sgif.api.entity.perfilusuario.model.PerfilUsuario;

/**
 * Service que fornece operações relacionadas a perfis de usuário
 * 
 * Esta classe contém métodos para criar, atualizar, excluir e recuperar
 * informações de perfis de usuários.
 *
 * @author Andesson Reis
 * @since V1.0.1
 */
@Service
public class ServicePerfilUsuario implements IServicePerfilUsuario {
    // =========================================================== //
    // =============== [ ATRIBUTOS ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoPerfilUsuario daoPerfilUsuario;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ MÉTODOS ] ================== //
    // =========================================================== //

    /**
     * @author Andesson Reis
     * Desde V1.0.1
     * 
     *Salva um perfil de usuário (Response DTO) na base de dados.
     *
     * @param perfilUsuario perfil de usuário (Response DTO) a ser salvo.
     * 
     * @return O perfil de usuário (Response DTO) salvo.
     */
    @Override
    public PerfilUsuarioResponseDto savePerfilUsuario(PerfilUsuario perfilUsuario) {
        return objectMapperUtil.map(
                daoPerfilUsuario.save(perfilUsuario),
                PerfilUsuarioResponseDto.class);
    }

    /**
     * 
     * @author Andesson Reis
     *         Desde V1.0.1
     * 
     *         Atualiza um perfil de usuário (Response DTO) na base de dados.
     *
     * @param perfilUsuarioResponseDTO O perfil de usuário (Response DTO) a ser
     *                                 atualizado.
     * @return O perfil de usuário (Response DTO) atualizado.
     */
    @Override
    public PerfilUsuarioResponseDto updatePerfilDeUsuario(PerfilUsuario perfilUsuario) {

        daoPerfilUsuario.findById(perfilUsuario.getId())
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        return objectMapperUtil.map(
                daoPerfilUsuario.save(perfilUsuario),
                PerfilUsuarioResponseDto.class);
    }

    /**
     * @author Andesson Reis
     *         Desde V1.0.1
     *
     *         Deleta um perfil de usuário (Response DTO) da base de dados.
     *
     * @param Id id do perfil de usuário a ser deletado.
     */
    @Override
    public PerfilUsuarioResponseDto deletePerfilUsuario(Long id) {
        
           return this.daoPerfilUsuario.findById(id)
                .map(perfil -> {
                    daoPerfilUsuario.delete(perfil);
                    return objectMapperUtil.map(perfil, PerfilUsuarioResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * @author Andesson Reis
     *         Desde V1.0.1
     *
     *         Obtém uma lista de todos os perfis de usuário (Response DTO).
     *
     * @return Uma lista de perfis de usuário (Response DTO).
     */
    @Override
    public List<PerfilUsuarioResponseDto> getAllPerfilUsuario() {

        return objectMapperUtil.mapAll(
                this.daoPerfilUsuario.findAll(),
                PerfilUsuarioResponseDto.class);
    }

    /**
     * @author Andesson Reis
     * Desde V1.0.1
     * 
     * Encontra perfis de usuário (Response DTO) pelo nome.
     *
     * @param name O nome a ser pesquisado.
     * @return Uma lista de perfis de usuário (Response DTO) com o nome
     *         especificado.
     */
    @Override
    public List<PerfilUsuarioResponseDto> findByNome(String name) {
        
        return daoPerfilUsuario.findByNome(name)
        .stream()
        .map(objectMapperUtil.mapFn(PerfilUsuarioResponseDto.class))
                .collect(Collectors.toList());
    
    }
     
}
