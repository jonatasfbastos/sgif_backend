package br.com.ifba.entity.turma.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.entity.turma.model.Turma;

/**
 * @author Unknown
 * Editado por Giovane Neves
 * @since Desde V1.0.1
 */
@Repository
public interface ITurmaDao extends JpaRepository<Turma, Long>{

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * @param id O ID da turma a ser buscada na base de dados.
     * @return a turma atrelada ao ID passado por parâmetro, ou nulo,
     * caso não exista turma com este ID.
     */
    Optional<Turma> findById(UUID id);

    List<Turma> findByEtapaCursoId(Long id);

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * @param codigoTurma O código da turma a ser buscado na
     * base de dados.
     * @return 'true' caso exista uma turma com o código passado por
     * parâmetro na base de dados, 'false' caso contrário.
     */
    boolean existsByCodigoTurma(String codigoTurma);
}
