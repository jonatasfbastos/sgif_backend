package br.com.ifba.entity.turma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.entity.turma.model.Turma;

@Repository
public interface IDaoTurma extends JpaRepository<Turma, Long>{
    
    List<Turma> findByEtapaCursoId(Long id);
    
}
