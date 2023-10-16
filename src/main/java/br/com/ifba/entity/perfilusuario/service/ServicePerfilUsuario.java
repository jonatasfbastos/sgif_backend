package br.com.ifba.entity.perfilusuario.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.support.StringUtil;
import br.com.ifba.entity.perfilusuario.dao.IDaoPerfilUsuario;
import br.com.ifba.entity.perfilusuario.dto.PerfilUsuarioResponseDto;
import br.com.ifba.entity.perfilusuario.model.PerfilUsuario;

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

    // =========================================================== //
    // =============== [ MÉTODOS ] ================== //
    // =========================================================== //

    /**
     * Salva um perfil de usuário (Response DTO) na base de dados.
     *
     * @param perfilUsuario perfil de usuário (Response DTO) a ser salvo.
     * @return O perfil de usuário (Response DTO) salvo.
     */
    @Override
    public PerfilUsuarioResponseDto savePerfilUsuario(PerfilUsuario perfilUsuario) {
        return daoPerfilDeUsuario.save()
    }

    /**
     * 
     * @author Andesson Reis
     * Desde V1.0.1
     * 
     * Atualiza um perfil de usuário (Response DTO) na base de dados.
     *
     * @param perfilUsuarioResponseDTO O perfil de usuário (Response DTO) a ser
     *                                 atualizado.
     * @return O perfil de usuário (Response DTO) atualizado.
     */
    @Override
    public PerfilUsuarioResponseDto updatePerfilDeUsuario(PerfilUsuario perfilUsuario) {

        return daoPerfilUsuario.findById(perfilUsuario.getId())
                .map(perfilUsuarioAtual -> {
                    perfilUsuarioAtual.setNome(perfilUsuario.getNome());
                    return daoPerfilUsuario.save(perfilUsuarioAtual).toResponseDto();
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * @author Andesson Reis
     *Desde V1.0.1
     *
     *Deleta um perfil de usuário (Response DTO) da base de dados.
     *
     * @param Id id do perfil de usuário a ser deletado.
     */
    @Override
    public PerfilUsuarioResponseDto deletePerfilUsuario(Long id) {
        PerfilUsuario perfilUsuario = daoPerfilUsuario.findById(id)
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        daoPerfilUsuario.delete(perfilUsuario);

        return perfilUsuario.toResponseDto();
    }

    @Override
    public List<PerfilUsuario> getAllPerfilUsuario() {
        return (List<PerfilUsuario>) this.daoPerfilDeUsuario.findAll();
    }

    @Override
    public List<PerfilUsuario> findByNome(String name) {
        if (name == null) {
            throw new BusinessException("Nome null");
        } else if (name.isEmpty()) {
            throw new BusinessException("Nome vazio");
        } else {
            return daoPerfilDeUsuario.findByNome(name);
        }
    }

    @Override
    public List<PerfilUsuario> findPerfisByPermissaoId(Long id) {
        return daoPerfilDeUsuario.findByPermissoesId(id);
    }

}
