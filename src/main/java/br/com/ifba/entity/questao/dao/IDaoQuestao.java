package br.com.ifba.entity.questao.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.questao.model.Questao;

public interface IDaoQuestao extends JpaRepository<Questao, Long>{
    
    public abstract List<Questao> findByEnunciado(String enunciado);
    public boolean existsByEnunciado(String nome);

}
