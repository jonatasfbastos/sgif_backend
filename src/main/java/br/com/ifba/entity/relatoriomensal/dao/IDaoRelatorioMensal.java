package br.com.ifba.entity.relatoriomensal.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.relatoriomensal.model.RelatorioMensal;



public interface IDaoRelatorioMensal extends JpaRepository<RelatorioMensal, UUID>{
    
    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra um RelatorioMensal pelo ID passado por parâmetro.
     * @param id O ID do RelatorioMensal a ser enconotrado.
     * @return um objeto opcional do tipo RelatorioMensal,
     * que será nulo caso o RelatorioMensal não exista na base de dados.
     */
    Optional<RelatorioMensal> findById(UUID id);
}
