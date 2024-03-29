package br.com.ifba.sgif.api.entity.tecnicoadministrativo.dao;

import br.com.ifba.sgif.api.entity.tecnicoadministrativo.model.TecnicoAdministrativo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDaoTecnicoAdministrativo extends JpaRepository<TecnicoAdministrativo, Long>{
    
    List<TecnicoAdministrativo> findByNome(String nome);
    boolean existsByNome(String nome);
           /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra um TecnicoAdministrativo pelo ID passado por parâmetro.
     * @param id O ID do TecnicoAdministrativo a ser encontrado.
     * @return um objeto opcional do tipo TecnicoAdministrativo,
     * que será nulo caso o TecnicoAdministrativo não exista na base de dados.
     */
    Optional<TecnicoAdministrativo> findById(Long id);
}
