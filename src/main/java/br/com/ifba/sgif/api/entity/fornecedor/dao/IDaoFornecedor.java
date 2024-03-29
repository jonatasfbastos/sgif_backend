
package br.com.ifba.sgif.api.entity.fornecedor.dao;

import java.util.Optional;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.fornecedor.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vitor
 */
public interface IDaoFornecedor extends JpaRepository<Fornecedor, Long> {
   /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra um fornecedor pelo ID passado por parâmetro.
     * @param id O ID do fornecedor a ser enconotrado.
     * @return um objeto opcional do tipo fornecedor,
     * que será nulo caso o fornecedor não exista na base de dados.
     */
    Optional<Fornecedor> findById(Long id);

      /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Verifica se existe um fornecedor com o ID passado por parâmetro
     * na base de dados.
     * @param id O id do fornecedor a ser consultado.
     * @return 'true' caso haja um fornecedor com o Id
     * passado por parâmetro na base de dados,
     * 'false' caso contrário.
     */
    boolean existsById(Long id);
}
