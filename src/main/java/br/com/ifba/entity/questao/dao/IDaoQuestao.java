package br.com.ifba.entity.questao.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.entity.questao.model.Questao;

@Repository
public interface IDaoQuestao extends JpaRepository<Questao, Long>{
    
    List<Questao> findByEnunciado(String enunciado);
    boolean existsByEnunciado(String nome);

}
