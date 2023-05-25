package br.com.ifba.etapacurso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.etapacurso.model.EtapaCurso;

public interface IDaoEtapaCurso extends JpaRepository<EtapaCurso, Long>{
    public abstract List<EtapaCurso> findByNome(String nome);
    public boolean existsByNome(String nome);

    
}
