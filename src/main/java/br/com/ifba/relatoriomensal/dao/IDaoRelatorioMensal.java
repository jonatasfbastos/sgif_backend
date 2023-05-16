package br.com.ifba.relatoriomensal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.relatoriomensal.model.RelatorioMensal;


public interface IDaoRelatorioMensal extends JpaRepository<RelatorioMensal, Long>{
    
}
