package br.com.ifba.entity.matrizcurricular.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.entity.matrizcurricular.model.MatrizCurricular;

@Repository
public interface IDaoMatrizCurricular extends JpaRepository<MatrizCurricular, Long>{
    List<MatrizCurricular> findByNome(String nome);
    boolean existsByNome(String nome);
    boolean existsById(Long id);
}
