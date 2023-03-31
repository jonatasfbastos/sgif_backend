package br.com.ifba.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.curso.model.Curso;

public interface IDaoCurso extends JpaRepository<Curso, Long>{
    
}
