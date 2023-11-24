package br.com.ifba.sgif.api.entity.formulario.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.formulario.model.Formulario;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Repository
public interface IDaoFormulario extends JpaRepository<Formulario, UUID>{

    // =========================================================== //
    // =============== [ ASSINATURAS DE MÉTODOS ] ================ //
    // =========================================================== //

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * Encontra um formulário pelo ID passado por parâmetro.
     * @param id O ID do formulário a ser enconotrado.
     * @return um objeto opcional do tipo formulário,
     * que será nulo caso o formulário não exista na base de dados.
     */
    Optional<Formulario> findById(UUID id);

    List<Formulario> findByTitulo(String titulo);

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * Verifica se existe um formulário com o ID passado por parâmetro
     * na base de dados.
     * @param id O id do furmulário a ser consultado.
     * @return 'true' caso haja um formulário com o Id
     * passado por parâmetro na base de dados,
     * 'false' caso contrário.
     */
    boolean existsById(UUID id);

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * Verifica se existe um formulário com o título passado por parâmetro
     * na base de dados.
     * @param titulo O título do formulário a ser consultado
     * @return 'true' caso haja um formulário com o título
     * passado por parâmetro na base de dados,
     * 'false' caso contrário.
     */
    boolean existsByTitulo(String titulo);

}
