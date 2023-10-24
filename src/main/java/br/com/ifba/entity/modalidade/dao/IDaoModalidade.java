package br.com.ifba.entity.modalidade.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.modalidade.model.Modalidade;
import org.springframework.stereotype.Repository;

@Repository
public interface IDaoModalidade extends JpaRepository<Modalidade, Long>{
    List <Modalidade> findByNome(String nome);
           /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra um modalidade pelo ID passado por parâmetro.
     * @param id O ID do modalidade a ser encontrado.
     * @return um objeto opcional do tipo modalidade,
     * que será nulo caso o modalidade não exista na base de dados.
     */
    Optional<Modalidade> findById(UUID id);
}
