package br.com.ifba.entity.relatoriomensal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.relatoriomensal.model.RelatorioMensal;


public interface IDaoRelatorioMensal extends JpaRepository<RelatorioMensal, Long>{
    
}
