
package br.com.ifba.entity.fornecedor.dao;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.fornecedor.model.Fornecedor;

/**
 *
 * @author vitor
 */
public interface IDaoFornecedor extends JpaRepository<Fornecedor, UUID> {
   /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra um fornecedor pelo ID passado por parâmetro.
     * @param id O ID do fornecedor a ser enconotrado.
     * @return um objeto opcional do tipo fornecedor,
     * que será nulo caso o fornecedor não exista na base de dados.
     */
    Optional<Fornecedor> findById(UUID id);

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
    boolean existsById(UUID id);
}
