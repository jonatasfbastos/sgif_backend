package br.com.ifba.etapacursoo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.etapacursoo.model.EtapaCurso;

@Repository
public interface IDaoEtapaCurso extends JpaRepository<EtapaCurso, Long>{
    public abstract List<EtapaCurso> findByNome(String nome);
    public boolean existsByNome(String nome);
}
