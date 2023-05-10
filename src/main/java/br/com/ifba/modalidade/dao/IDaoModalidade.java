package br.com.ifba.modalidade.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.modalidade.model.Modalidade;

public interface IDaoModalidade extends JpaRepository<Modalidade, Long>{
    public abstract List <Modalidade> findByNome(String nome);
}
