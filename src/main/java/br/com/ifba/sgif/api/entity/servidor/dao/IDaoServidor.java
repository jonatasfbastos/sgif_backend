package br.com.ifba.sgif.api.entity.servidor.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.sgif.api.entity.servidor.model.Servidor;

public interface IDaoServidor extends JpaRepository<Servidor, Long>{
    
    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Verifica se existe um Servidor com o ID passado por parâmetro
     * na base de dados.
     * @param id O id do servidor a ser consultado.
     * @return 'true' caso haja um servidor com o Id
     * passado por parâmetro na base de dados,
     * 'false' caso contrário.
     */
    boolean existsById(Long id);

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra uma Servidor pelo ID passado por parâmetro.
     * @param id O ID da Servidor a ser encontrado.
     * @return um objeto opcional do tipo Servidor,
     * que será nulo caso o Servidor não exista na base de dados.
     */
    Optional<Servidor> findById(Long id);


    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * <p>
     * Verifica se existe um servidor com o siape passado por parâmetro
     * na base de dados.
     * @param siape O siape do servidor a ser consultado
     * @return 'true' caso haja um servidor com o siape
     * passado por parâmetro na base de dados,
     * 'false' caso contrário.
     */
    boolean existsBySiape(String siape);
}
