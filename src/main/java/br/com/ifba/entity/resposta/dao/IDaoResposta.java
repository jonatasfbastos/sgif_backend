package br.com.ifba.entity.resposta.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.resposta.model.Resposta;

public interface IDaoResposta extends JpaRepository<Resposta, Long>{
    
    
}
