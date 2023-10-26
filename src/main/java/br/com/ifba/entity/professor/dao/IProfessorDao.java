package br.com.ifba.entity.professor.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.entity.professor.model.Professor;

@Repository
public interface IProfessorDao extends JpaRepository<Professor, Long>{

    Optional<Professor> findById(UUID id);
    List<Professor> findByNome(String nome);
    boolean existsByNome(String nome);
    boolean existsBySiape(String siape);
}
