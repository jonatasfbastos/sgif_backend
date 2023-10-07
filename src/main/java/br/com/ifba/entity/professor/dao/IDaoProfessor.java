package br.com.ifba.entity.professor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.entity.professor.model.Professor;

@Repository
public interface IDaoProfessor extends JpaRepository<Professor, Long>{
    List<Professor> findByNome(String nome);
    boolean existsByNome(String nome);
    boolean existsBySiape(String siape);
}
