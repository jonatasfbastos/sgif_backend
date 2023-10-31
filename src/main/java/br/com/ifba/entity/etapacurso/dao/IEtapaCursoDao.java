package br.com.ifba.entity.etapacurso.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.entity.etapacurso.model.EtapaCurso;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Repository
public interface IEtapaCursoDao extends JpaRepository<EtapaCurso, UUID>{

    /**
     * Busca uma estapa de curso na base de dados com base no ID
     * passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da etapa de curso a ser buscada.
     * @return a etapa de curso atrelada ao ID passado por parâmetro,
     * ou nulo, caso não exista.
     */
    Optional<EtapaCurso> findById(UUID id);

    /**
     * Busca etapas de curso na base de dados com base no nome
     * passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param nome O nome das etapas de curso a serem buscadas.
     * @return lista das etapas de curso que possuem o nome passado por parâmetro.
     */
    List<EtapaCurso> findByNome(String nome);

    /**
     * Verifica se existe alguma etapa de curso com o nome
     * passado por parâmetro na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param nome O nome da etapa de curso a ser verificada.
     * @return 'true' caso haja uma etapa de curso com o nome passado por
     * parâmetro na base de dados, 'false' caso contrário.
     */
    boolean existsByNome(String nome);

    
}
