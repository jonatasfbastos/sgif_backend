package br.com.ifba.sgif.api.entity.resposta.dao;

import br.com.ifba.sgif.api.entity.resposta.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDaoResposta extends JpaRepository<Resposta, Long>{
    
    
}
