package br.com.ifba.entity.requisicao.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.requisicao.model.Requisicao;

/**
 *
 * @author Vitor
 */
public interface IDaoRequisicao extends JpaRepository<Requisicao, Long> { 
    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Verifica se existe uma requisição com o ID passado por parâmetro
     * na base de dados.
     * @param id O id do requisição a ser consultado.
     * @return 'true' caso haja um formulário com o Id
     * passado por parâmetro na base de dados,
     * 'false' caso contrário.
     */
    boolean existsById(UUID id);


}
