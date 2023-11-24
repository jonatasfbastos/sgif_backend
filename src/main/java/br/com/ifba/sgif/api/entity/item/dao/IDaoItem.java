package br.com.ifba.sgif.api.entity.item.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.item.model.Item;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author vitor
 */
@Repository
public interface IDaoItem extends JpaRepository<Item, UUID> {

    List<Item> findByNome(String name);

    List<Item> dataNotBefore(Date dataNot);

    List<Item> validadeAfter(Date validade);

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra um item pelo ID passado por parâmetro.
     * @param id O ID do item a ser enconotrado.
     * @return um objeto opcional do tipo item,
     * que será nulo caso o item não exista na base de dados.
     */
    Optional<Item> findById(UUID id);

      /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Verifica se existe um item com o ID passado por parâmetro
     * na base de dados.
     * @param id O id do item a ser consultado.
     * @return 'true' caso haja um item com o Id
     * passado por parâmetro na base de dados,
     * 'false' caso contrário.
     */
    boolean existsById(UUID id);
}
