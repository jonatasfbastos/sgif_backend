package br.com.ifba.disciplina.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.disciplina.model.Disciplina;

public interface IDaoDisciplina extends JpaRepository<Disciplina, Long>{
    List<Disciplina> findByNome(String nome);
    public boolean existsByNome(String nome);
    public boolean existsByDescricao(String descricao); 
}
