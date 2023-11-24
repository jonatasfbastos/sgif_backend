package br.com.ifba.sgif.api.entity.requisicao.dao;

import java.util.Optional;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.requisicao.model.Requisicao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vitor
 */
public interface IDaoRequisicao extends JpaRepository<Requisicao, UUID> {
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

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra uma requisição pelo ID passado por parâmetro.
     * @param id O ID da requisição a ser enconotrado.
     * @return um objeto opcional do tipo requisição,
     * que será nulo caso o requisição não exista na base de dados.
     */
    Optional<Requisicao> findById(UUID id);

}
