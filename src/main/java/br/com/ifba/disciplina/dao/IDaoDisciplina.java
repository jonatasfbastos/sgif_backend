package br.com.ifba.disciplina.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.disciplina.model.Disciplina;

@Repository
public interface IDaoDisciplina extends JpaRepository<Disciplina, Long>{
    List<Disciplina> findByNome(String nome); 
}
