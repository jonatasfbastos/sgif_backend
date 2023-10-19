package br.com.ifba.entity.curso.dao;

import br.com.ifba.entity.curso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Unknown
 * Editado por Giovane Neves
 * Desde V1.0.1
 */
public interface IDaoCurso extends JpaRepository<Curso, Long>{

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     *
     * Encontra um formulário pelo ID passado por parâmetro.
     * @param id O ID do formulário a ser enconotrado.
     * @return um objeto opcional do tipo formulário,
     * que será nulo caso o formulário não exista na base de dados.
     */
    Optional<Curso> findById(UUID id);

    List <Curso> findByNome (String nome);
}
