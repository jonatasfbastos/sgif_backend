package br.com.ifba.entity.curso.dao;

import br.com.ifba.entity.curso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDaoCurso extends JpaRepository<Curso, Long>{
    
    List <Curso> findByNome (String nome);
}
