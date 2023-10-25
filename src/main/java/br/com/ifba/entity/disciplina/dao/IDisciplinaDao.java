package br.com.ifba.entity.disciplina.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.entity.disciplina.model.Disciplina;

@Repository
public interface IDaoDisciplina extends JpaRepository<Disciplina, Long>{
    List<Disciplina> findByNome(String nome);
    boolean existsByNome(String nome);
    boolean existsByDescricao(String descricao);
}
