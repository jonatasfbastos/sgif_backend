package br.com.ifba.sgif.api.entity.setor.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.ifba.sgif.api.entity.setor.model.Setor;

/**
 *
 * @author Everton.
 */
@Repository
public interface IDaoSetor extends JpaRepository<Setor, UUID> {

   List<Setor> findByNome(String name);

   /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra um setor pelo ID passado por parâmetro.
     * @param id O ID do setor a ser enconotrado.
     * @return um objeto opcional do tipo de setor,
     * que será nulo caso o setor não exista na base de dados.
     */
    Optional<Setor> findById(UUID id);

}
