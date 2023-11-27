package br.com.ifba.sgif.api.entity.professor.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.professor.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfessorDao extends JpaRepository<Professor, Long>{

    Optional<Professor> findById(Long id);
    List<Professor> findByNome(String nome);
    boolean existsByNome(String nome);
    boolean existsBySiape(String siape);
}
