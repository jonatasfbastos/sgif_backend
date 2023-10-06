package br.com.ifba.mensagem.dao;

import br.com.ifba.mensagem.model.Mensagem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author felip
 */
@Repository
public interface IDaoMensagem extends JpaRepository<Mensagem, Long>{
     List<Mensagem> findByNome(String name);
     boolean existsByNome(String nome);
}
