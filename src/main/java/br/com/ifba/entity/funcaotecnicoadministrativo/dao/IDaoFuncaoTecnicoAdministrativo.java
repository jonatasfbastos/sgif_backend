package br.com.ifba.entity.funcaotecnicoadministrativo.dao;

import br.com.ifba.entity.funcaotecnicoadministrativo.model.FuncaoTecnicoAdministrativo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDaoFuncaoTecnicoAdministrativo extends JpaRepository<FuncaoTecnicoAdministrativo, Long> {

    boolean existsByNome(String nome);
    boolean existsById(Long id);

}