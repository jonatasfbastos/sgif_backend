package br.com.ifba.funcaoterceirizado.dao;

import br.com.ifba.funcaoterceirizado.model.FuncaoTerceirizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ph715
 */
@Repository
public interface IDaoFuncaoTerceirizado extends JpaRepository<FuncaoTerceirizado, Long> {
    boolean existsByNome(String nome);
    boolean existsById(Long id);
}
