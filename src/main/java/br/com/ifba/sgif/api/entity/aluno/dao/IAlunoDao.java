package br.com.ifba.sgif.api.entity.aluno.dao;

import br.com.ifba.sgif.api.entity.aluno.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Unknown
 * Editado por Giovane Neves
 * @since Desde V1.0.1
 */
@Repository
public interface IAlunoDao extends JpaRepository<Aluno, Long> {

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * @param id O ID do aluno a ser buscado.
     * @return o aluno atrelado ao ID passado por parâmetro,
     * ou nulo, caso não exista.
     */
    Optional<Aluno> findAlunoById(Long id);

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * Verifica se há um aluno com a matrícula passada por parâmetro
     * cadastrado na base de dados.
     * @param matricula A matrícula a ser consultada.
     * @return 'true' caso exista cum aluno cadastrado na base de dados
     * com a matrícula passada por parâmetro.
     */
    boolean existsAlunoByMatricula(String matricula);

}

