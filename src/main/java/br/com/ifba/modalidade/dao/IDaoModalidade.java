package br.com.ifba.modalidade.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.modalidade.model.Modalidade;
import org.springframework.stereotype.Repository;

@Repository
public interface IDaoModalidade extends JpaRepository<Modalidade, Long>{
    List <Modalidade> findByNome(String nome);
}
