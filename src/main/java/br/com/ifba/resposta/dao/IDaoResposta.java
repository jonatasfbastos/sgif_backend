package br.com.ifba.resposta.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.resposta.model.Resposta;

public interface IDaoResposta extends JpaRepository<Resposta, Long>{
    
    
}
