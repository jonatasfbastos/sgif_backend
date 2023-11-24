package br.com.ifba.sgif.api.entity.tecnicoadministrativo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.tecnicoadministrativo.model.TecnicoAdministrativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDaoTecnicoAdministrativo extends JpaRepository<TecnicoAdministrativo, UUID>{
    
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
    Optional<TecnicoAdministrativo> findById(UUID id);
}
