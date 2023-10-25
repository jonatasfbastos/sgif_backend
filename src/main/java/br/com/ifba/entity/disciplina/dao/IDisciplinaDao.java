package br.com.ifba.entity.disciplina.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.entity.disciplina.model.Disciplina;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Repository
public interface IDisciplinaDao extends JpaRepository<Disciplina, Long>{

    /**
     * Busca uma disciplina na base de dados com base no ID
     * passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da disciplina a ser buscada.
     * @return a disciplina atrelada ao ID passado por parâmetro,
     * ou nulo, caso não exista.
     */
    Optional<Disciplina> findById(UUID id);

    /**
     * Busca disciplinas na base de dados com base no nome
     * passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param nome O nome das disciplinas a serem buscadas.
     * @return lista das disciplinas que possuem o nome passado por parâmetro.
     */
    List<Disciplina> findByNome(String nome);


    /**
     * Verifica se existe alguma disciplina com o nome
     * passado por parâmetro na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param nome O nome da disciplina a ser verificada.
     * @return 'true' caso haja uma disciplina com o nome passado por
     * parâmetro na base de dados, 'false' caso contrário.
     */
    boolean existsByNome(String nome);

}
