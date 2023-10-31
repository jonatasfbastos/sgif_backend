package br.com.ifba.entity.matrizcurricular.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.entity.matrizcurricular.model.MatrizCurricular;

@Repository
public interface IDaoMatrizCurricular extends JpaRepository<MatrizCurricular, UUID>{
    List<MatrizCurricular> findByNome(String nome);
    boolean existsByNome(String nome);
    boolean existsById(Long id);
    Optional<MatrizCurricular> findById(UUID id);
}
