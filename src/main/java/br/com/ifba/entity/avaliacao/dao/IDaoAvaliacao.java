package br.com.ifba.entity.avaliacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.avaliacao.model.Avaliacao;

public interface IDaoAvaliacao extends JpaRepository<Avaliacao, Long> {
    
}
