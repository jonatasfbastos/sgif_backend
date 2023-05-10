package br.com.ifba.turma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.turma.model.Turma;

public interface IDaoTurma extends JpaRepository<Turma, Long>{
    
}
