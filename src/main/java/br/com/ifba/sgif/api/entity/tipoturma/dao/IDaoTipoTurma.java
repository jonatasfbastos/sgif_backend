package br.com.ifba.sgif.api.entity.tipoturma.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.tipoturma.model.TipoTurma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDaoTipoTurma extends JpaRepository<TipoTurma, Long>{

    List<TipoTurma> findByNome(String nome);
    boolean existsByNome(String nome);

       /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra um TipoTurma pelo ID passado por parâmetro.
     * @param id O ID do TipoTurma a ser encontrado.
     * @return um objeto opcional do tipo TipoTurma,
     * que será nulo caso o TipoTurma não exista na base de dados.
     */
    Optional<TipoTurma> findById(UUID id);

      /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Verifica se existe um TipoTurma com o ID passado por parâmetro
     * na base de dados.
     * @param id O id do TipoTurma a ser consultado.
     * @return 'true' caso haja um TipoTurma com o Id
     * passado por parâmetro na base de dados,
     * 'false' caso contrário.
     */
    boolean existsById(UUID id);
}
