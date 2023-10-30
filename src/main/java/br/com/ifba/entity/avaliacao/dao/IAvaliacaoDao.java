package br.com.ifba.entity.avaliacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.avaliacao.model.Avaliacao;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Repository
public interface IAvaliacaoDao extends JpaRepository<Avaliacao, UUID> {

    /**
     * Busca uma avaliação na base de dados com base no ID
     * passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da avaliação a ser buscada.
     * @return a avaliação atrelada ao ID passado por parâmetro,
     * ou nulo, caso não exista.
     */
    Optional<Avaliacao> findById(UUID id);

    /**
     * Verifica se existe uma avaliação com o ID
     * passado por parâmetro na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da avaliação a ser verificada.
     * @return 'true' caso haja uma avaliação com o ID passado por
     * parâmetro na base de dados, 'false' caso contrário.
     */
    boolean existsById(UUID id);
}
