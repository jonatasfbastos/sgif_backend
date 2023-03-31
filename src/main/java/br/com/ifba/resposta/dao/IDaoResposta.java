package br.com.ifba.resposta.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.resposta.model.Resposta;

@Repository
public interface IDaoResposta extends JpaRepository<Resposta, Long>{
    
    
}
