package br.com.ifba.etapacurso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.etapacurso.model.EtapaCurso;

@Repository
public interface IDaoEtapaCurso extends JpaRepository<EtapaCurso, Long>{
    List<EtapaCurso> findByNome(String nome);
    boolean existsByNome(String nome);

    
}
