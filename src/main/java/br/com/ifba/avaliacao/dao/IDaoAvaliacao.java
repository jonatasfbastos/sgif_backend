package br.com.ifba.avaliacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.avaliacao.model.Avaliacao;

public interface IDaoAvaliacao extends JpaRepository<Avaliacao, Long>{
    
}
