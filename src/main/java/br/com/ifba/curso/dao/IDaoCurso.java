package br.com.ifba.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ifba.curso.model.Curso;
import java.util.List;

public interface IDaoCurso extends JpaRepository<Curso, Long>{
    
    List <Curso> findByNome (String nome);
}
