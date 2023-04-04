package br.com.ifba.tecnicoadministrativoo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.tecnicoadministrativoo.model.TecnicoAdministrativo;

@Repository
public interface IDaoTecnicoAdministrativo extends JpaRepository<TecnicoAdministrativo, Long>{
    public List<TecnicoAdministrativo> findByNome(String nome);
    public boolean existsByNome(String nome);
}
