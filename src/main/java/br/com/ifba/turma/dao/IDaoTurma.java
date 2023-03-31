package br.com.ifba.turma.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.turma.model.Turma;

@Repository
public interface IDaoTurma extends JpaRepository<Turma, Long>{
    
}
