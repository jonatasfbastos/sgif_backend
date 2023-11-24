package br.com.ifba.sgif.api.entity.funcaoservidor.dao;

import br.com.ifba.sgif.api.entity.funcaoservidor.model.FuncaoServidor;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDaoFuncaoServidor extends JpaRepository<FuncaoServidor, UUID> {
       /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra um FuncaoServidor pelo ID passado por parâmetro.
     * @param id O ID do FuncaoServidor a ser encontrado.
     * @return um objeto opcional do tipo Empenho,
     * que será nulo caso o FuncaoServidor não exista na base de dados.
     */
    Optional<FuncaoServidor> findById(UUID id);

      /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Verifica se existe um FuncaoServidor com o ID passado por parâmetro
     * na base de dados.
     * @param id O id do FuncaoServidor a ser consultado.
     * @return 'true' caso haja um FuncaoServidor com o Id
     * passado por parâmetro na base de dados,
     * 'false' caso contrário.
     */
    boolean existsById(UUID id);
}