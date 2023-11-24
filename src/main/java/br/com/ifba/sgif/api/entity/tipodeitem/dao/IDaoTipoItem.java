package br.com.ifba.sgif.api.entity.tipodeitem.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import br.com.ifba.sgif.api.entity.tipodeitem.model.TipoDeItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dudasss
 */
@Repository
public interface IDaoTipoItem extends JpaRepository<TipoDeItem, UUID> {

    List<TipoDeItem> findByNome(String name);

        /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Verifica se existe um TipoDeItem com o ID passado por parâmetro
     * na base de dados.
     * @param id O id do TipoDeItem a ser consultado.
     * @return 'true' caso haja um TipoDeItem com o Id
     * passado por parâmetro na base de dados,
     * 'false' caso contrário.
     */
    boolean existsById(UUID id);

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra um TipoDeItem pelo ID passado por parâmetro.
     * @param id O ID do TipoDeItem a ser enconotrado.
     * @return um objeto opcional do tipo TipoDeItem,
     * que será nulo caso o TipoDeItem não exista na base de dados.
     */
    Optional<TipoDeItem> findById(UUID id);

}