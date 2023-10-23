package br.com.ifba.entity.funcaotecnicoadministrativo.dao;

import br.com.ifba.entity.funcaotecnicoadministrativo.model.FuncaoTecnicoAdministrativo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDaoFuncaoTecnicoAdministrativo extends JpaRepository<FuncaoTecnicoAdministrativo, Long> {

    boolean existsByNome(String nome);
    boolean existsById(Long id);

           /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra um FuncaoTecnicoAdministrativo pelo ID passado por parâmetro.
     * @param id O ID do FuncaoTecnicoAdministrativo a ser encontrado.
     * @return um objeto opcional do tipo FuncaoTecnicoAdministrativo,
     * que será nulo caso o FuncaoTecnicoAdministrativo não exista na base de dados.
     */
    Optional<FuncaoTecnicoAdministrativo> findById(UUID id);
}