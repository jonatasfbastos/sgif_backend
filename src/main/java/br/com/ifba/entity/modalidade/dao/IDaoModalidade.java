package br.com.ifba.entity.modalidade.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.modalidade.model.Modalidade;
import org.springframework.stereotype.Repository;

@Repository
public interface IDaoModalidade extends JpaRepository<Modalidade, Long>{
    List <Modalidade> findByNome(String nome);
}
