package br.com.ifba.entity.etapacurso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.entity.etapacurso.model.EtapaCurso;

@Repository
public interface IEtapaCursoDao extends JpaRepository<EtapaCurso, Long>{
    List<EtapaCurso> findByNome(String nome);
    boolean existsByNome(String nome);

    
}
