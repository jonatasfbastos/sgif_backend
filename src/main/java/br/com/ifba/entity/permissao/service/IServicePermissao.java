package br.com.ifba.entity.permissao.service;

import br.com.ifba.entity.permissao.dto.PermissaoResponseDto;
import br.com.ifba.entity.permissao.model.Permissao;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author unknown
 * @since V1.0.1
 * @Editado por Andesson Reis
 */
public interface IServicePermissao {
    /**
     * Salva uma Permissão na base de dados e retorna um objeto DTO
     *
     *
     * @param permissao - A Permissão que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos da permissão salva.
     */
    PermissaoResponseDto savePermissao(Permissao permissao);

    /**
     * Deleta uma Permissão.
     *
     * @param id O ID da permissão a ser deletado.
     * @return objeto DTO com os dados da permissão deletado.
     */
    PermissaoResponseDto deletePermissao(UUID id);

    /**
     * Atualiza uma permissão na base de dados.
     *
     * @param permissao A permissão a ser atualizado.
     * @return A permissão atualizado.
     */
    PermissaoResponseDto updatePermissao(Permissao permissao);

    /**
     * Obtém uma lista de todas as permissão como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as permissões.
     */
    List<PermissaoResponseDto> getAllPermissoes();

    /**
     * Encontra permissões por ID.
     *
     * @param id O id do perfil de usuario a ser pesquisado.
     * @return Uma lista de permissões atrelado ao perfil.
     */
    List<PermissaoResponseDto> getAllByPerfilId(UUID id);

    /**
     * 
     *
     * @param id
     * @return
     */
    List<PermissaoResponseDto> getAllByLinkId(UUID id);

}