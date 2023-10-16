package br.com.ifba.entity.formulario.dao;

import java.util.List;
import java.util.Optional;

import br.com.ifba.entity.formulario.model.Formulario;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IDaoFormulario extends JpaRepository<Formulario, Long>{

    /**
     * Encontra um formulário pelo ID passado por parâmetro.
     *
     * @param id O ID do formulário a ser enconotrado.
     *
     * @return um objeto opcional do tipo formulário,
     * que será nulo caso o formulário não exista na base de dados.
     */
    Optional<Formulario> findById(Long id);

    List<Formulario> findByTitulo(String titulo);
    boolean existsByTitulo(String titulo);
    boolean existsById(Long id);

}
