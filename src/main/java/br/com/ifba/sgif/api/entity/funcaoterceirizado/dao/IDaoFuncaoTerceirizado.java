package br.com.ifba.sgif.api.entity.funcaoterceirizado.dao;


import br.com.ifba.sgif.api.entity.funcaoterceirizado.model.FuncaoTerceirizado;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ph715
 */
@Repository
public interface IDaoFuncaoTerceirizado extends JpaRepository<FuncaoTerceirizado, UUID> {
    boolean existsByNome(String nome);
    boolean existsById(Long id);

           /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra uma FuncaoTerceirizado pelo ID passado por parâmetro.
     * @param id O ID da FuncaoTerceirizado a ser enconotrado.
     * @return um objeto opcional do tipo Empenho,
     * que será nulo caso a FuncaoTerceirizado não exista na base de dados.
     */
    Optional<FuncaoTerceirizado> findById(UUID id);

      /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Verifica se existe uma FuncaoTerceirizado com o ID passado por parâmetro
     * na base de dados.
     * @param id O id da FuncaoTerceirizado a ser consultado.
     * @return 'true' caso haja uma FuncaoTerceirizado com o Id
     * passado por parâmetro na base de dados,
     * 'false' caso contrário.
     */
    boolean existsById(UUID id);
}
