package br.com.ifba.sgif.api.entity.questao.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.questao.model.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Giovane Neves
 * @since V1.0.1
 */
@Repository
public interface IQuestaoDao extends JpaRepository<Questao, Long>{

    /**
     * Busca uma questão na base de dados com base no ID
     * passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da questão a ser buscada.
     * @return a questão atrelada ao ID passado por parâmetro,
     * ou nulo, caso não exista.
     */
    Optional<Questao> findById(Long id);

    /**
     * Busca uma questão na base de dados com base no ID
     * passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param enunciado O enunciado das questões a serem buscadas.
     * @return Lista das questões que possuem o enunciado passado por parâmetro.
     */
    List<Questao> findByEnunciado(String enunciado);

    /**
     * Verifica se existe alguma avaliação com o enunciado
     * passado por parâmetro na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param enunciado O enunciado da avaliação a ser verificada.
     * @return 'true' caso haja uma questão com o enunciado passado por
     * parâmetro na base de dados, 'false' caso contrário.
     */
    boolean existsByEnunciado(String enunciado);


}
