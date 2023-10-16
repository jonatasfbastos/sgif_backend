package br.com.ifba.entity.perfilusuario.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
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
     * @author Andesson Reis
     * Desde V1.0.1
     * Salva um perfil de usuário (Response DTO) na base de dados.
     *
     * @param perfilUsuario perfil de usuário (Response DTO) a ser salvo.
     * @return O perfil de usuário (Response DTO) salvo.
     */
    @Override
    public PerfilUsuarioResponseDto savePerfilUsuario(PerfilUsuario perfilUsuario) {
        return daoPerfilUsuario.save(perfilUsuario).toResponseDto();
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
     * Desde V1.0.1
     *
     * Deleta um perfil de usuário (Response DTO) da base de dados.
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

    /**
     * @author Andesson Reis
     * Desde V1.0.1
     *
     * Obtém uma lista de todos os perfis de usuário (Response DTO).
     *
     * @return Uma lista de perfis de usuário (Response DTO).
     */
    @Override
    public List<PerfilUsuarioResponseDto> getAllPerfilUsuario() {
        return this.daoPerfilUsuario.findAll().stream()
                .map(PerfilUsuario::toResponseDto)
                .collect(Collectors.toList());
    }
     /**
     * @author Andesson Reis
     * Desde V1.0.1
     * Encontra perfis de usuário (Response DTO) pelo nome.
     *
     * @param name O nome a ser pesquisado.
     * @return Uma lista de perfis de usuário (Response DTO) com o nome especificado.
     */
    @Override
    public List<PerfilUsuario> findByNome(String name) {
        if (name == null) {
            throw new BusinessException("Nome null");
        } else if (name.isEmpty()) {
            throw new BusinessException("Nome vazio");
        } else {
            return daoPerfilUsuario.findByNome(name);
        }
    }
    /**
     * Encontra perfis de usuário (Response DTO) por ID de permissão.
     *
     * @param id O ID da permissão a ser pesquisada.
     * @return Uma lista de perfis de usuário (Response DTO) com a permissão especificada.
     */
    /*
      @Override
      public List<PerfilUsuario> findPerfisByPermissaoId(Long id) {
      return daoPerfilDeUsuario.findByPermissoesId(id);
      }
    */
}
