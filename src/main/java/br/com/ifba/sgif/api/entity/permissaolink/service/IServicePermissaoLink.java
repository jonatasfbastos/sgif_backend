package br.com.ifba.sgif.api.entity.permissaolink.service;

import br.com.ifba.sgif.api.entity.permissaolink.dto.PermissaoLinkResponseDto;
import br.com.ifba.sgif.api.entity.permissaolink.model.PermissaoLink;

import java.util.List;

/**
 * Interface que define os serviços relacionados à entidade "PermissaoLink".
 *
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
 */
public interface IServicePermissaoLink {
    /**
     * Salva um PermissaoLink na base de dados e retorna um objeto DTO.
     *
     * @param permissaoLink - O PermissaoLink que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do PermissaoLink salvo.
     */
    PermissaoLinkResponseDto saveLink(PermissaoLink permissaoLink);

    /**
     * Deleta um PermissaoLink.
     *
     * @param id - O ID do PermissaoLink a ser deletado.
     * @return uma mensagem de confirmação de exclusão.
     */
    PermissaoLinkResponseDto deleteLink(Long id);

    /**
     * Atualiza um PermissaoLink na base de dados.
     *
     * @param permissaoLink - O PermissaoLink a ser atualizado.
     * @return o PermissaoLink atualizado.
     */
    PermissaoLinkResponseDto updateLink(PermissaoLink permissaoLink);

    /**
     * Obtém uma lista de todos os PermissaoLinks como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os PermissaoLinks.
     */
    List<PermissaoLinkResponseDto> getAllLinks();

    /**
     * Encontra PermissaoLinks por ID da Permissao associada.
     *
     * @param id - O ID da Permissao a ser pesquisada.
     * @return uma lista de PermissaoLinks associados à Permissao.
     */
    List<PermissaoLinkResponseDto> getAllByPermissaoId(Long id);
}
