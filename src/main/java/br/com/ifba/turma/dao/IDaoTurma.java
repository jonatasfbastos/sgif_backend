package br.com.ifba.turma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.turma.model.Turma;

public interface IDaoTurma extends JpaRepository<Turma, Long>{
    
    List<Turma> findByEtapaCursoId(Long id);
    
}
