package br.com.ifba.entity.tecnicoadministrativo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.tecnicoadministrativo.model.TecnicoAdministrativo;

public interface IDaoTecnicoAdministrativo extends JpaRepository<TecnicoAdministrativo, Long>{
    
    public List<TecnicoAdministrativo> findByNome(String nome);
    public boolean existsByNome(String nome);
}
