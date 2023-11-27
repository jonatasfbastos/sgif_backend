package br.com.ifba.sgif.api.entity.matrizcurricular.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.matrizcurricular.model.MatrizCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDaoMatrizCurricular extends JpaRepository<MatrizCurricular, Long>{
    List<MatrizCurricular> findByNome(String nome);
    boolean existsByNome(String nome);
    boolean existsById(Long id);
    Optional<MatrizCurricular> findById(Long id);
}
