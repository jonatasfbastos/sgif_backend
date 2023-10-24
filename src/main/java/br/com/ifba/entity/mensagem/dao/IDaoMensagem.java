package br.com.ifba.entity.mensagem.dao;


import br.com.ifba.entity.mensagem.model.Mensagem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author felip
 */
@Repository
public interface IDaoMensagem extends JpaRepository<Mensagem, Long>{
     List<Mensagem> findByNome(String name);
     boolean existsByNome(String nome);
            /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra um Mensagem pelo ID passado por parâmetro.
     * @param id O ID do Mensagem a ser encontrado.
     * @return um objeto opcional do tipo Mensagem,
     * que será nulo caso o Mensagem não exista na base de dados.
     */
    Optional<Mensagem> findById(UUID id);

      /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Verifica se existe um Mensagem com o ID passado por parâmetro
     * na base de dados.
     * @param id O id do Mensagem a ser consultado.
     * @return 'true' caso haja um Mensagem com o Id
     * passado por parâmetro na base de dados,
     * 'false' caso contrário.
     */
    boolean existsById(UUID id);
}
