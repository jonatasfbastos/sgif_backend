package br.com.ifba.entity.tecnicoadministrativo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.entity.tecnicoadministrativo.model.TecnicoAdministrativo;

@Repository
public interface IDaoTecnicoAdministrativo extends JpaRepository<TecnicoAdministrativo, Long>{
    
    List<TecnicoAdministrativo> findByNome(String nome);
    boolean existsByNome(String nome);
}
