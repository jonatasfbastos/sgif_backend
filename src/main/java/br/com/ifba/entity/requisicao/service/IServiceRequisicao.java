package br.com.ifba.entity.requisicao.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.entity.requisicao.dto.RequisicaoResponseDto;
import br.com.ifba.entity.requisicao.model.Requisicao;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vitor 
 * @Editado por Andesson Reis
 * Desde V1.0.1
 */

@Service
public interface IServiceRequisicao {

     /**
     * @author Andesson Reis
     * Desde V1.0.1
     * Salva uma requisição na base de dados e retorna um objeto DTO
     *
     *
     * @param permissao - A requisição que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos da requisição salva.
     */
    RequisicaoResponseDto saveRequisicao(Requisicao requisicao);

    /**
     * @author Andesson Reis
     * Desde V1.0.1

     * Atualiza uma requisição na base de dados.
     *
     * @param permissao A requisição a ser atualizado.
     * @return A requisição atualizado.
     */
     RequisicaoResponseDto updateRequisicao(Requisicao requisicao);

    /**
     * @author Andesson Reis
     * Desde V1.0.1
     *
     * Deleta uma requisição.
     *
     * @param id O ID da requisição a ser deletado.
     * @return objeto DTO com os dados da requisição deletado.
     */
    RequisicaoResponseDto deleteRequisicao(UUID id);

     /**
     * @author Andesson Reis
     * Desde V1.0.1
     *
     * Lista todos as requisições da base de dados.
     * @return uma lista com todas as requisições na base de dados.
     */
    List<RequisicaoResponseDto> getAllRequisicao();
}
