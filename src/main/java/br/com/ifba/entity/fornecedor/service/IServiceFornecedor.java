package br.com.ifba.entity.fornecedor.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.entity.fornecedor.dto.FornecedorResponseDto;
import br.com.ifba.entity.fornecedor.model.Fornecedor;

import org.springframework.stereotype.Service;

/**
 * Serviço para operações relacionadas a fornecedores.
 * 
*  @author vitor
 * @Editado por Andesson Reis
 * @since V1.0.1
 */
@Service
public interface IServiceFornecedor {

    /**
     * Salva um fornecedor na base de dados e retorna um objeto DTO com os dados resumidos do fornecedor salvo.
     *
     * @param fornecedor - O fornecedor que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do fornecedor salvo.
     */
    FornecedorResponseDto saveFornecedor(Fornecedor fornecedor);

    /**
     * Atualiza um fornecedor na base de dados e retorna um objeto DTO com os dados atualizados do fornecedor.
     *
     * @param fornecedor - O fornecedor que será atualizado na base de dados.
     * @return um objeto DTO com os dados atualizados do fornecedor.
     */
    FornecedorResponseDto updateFornecedor(Fornecedor fornecedor);

    /**
     * Deleta um fornecedor.
     *
     * @param id - O ID do fornecedor a ser deletado.
     * @return objeto DTO com os dados do fornecedor deletado.
     */
    FornecedorResponseDto deleteFornecedor(UUID id);

    /**
     * Obtém uma lista de todos os fornecedores como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os fornecedores.
     */
    List<FornecedorResponseDto> getAllFornecedores();
}
