package br.com.ifba.entity.terceirizado.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.ifba.entity.terceirizado.model.Terceirizado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDaoTerceirizado extends JpaRepository<Terceirizado, UUID> {

    List<Terceirizado> findFuncaoTerceirizadoById(UUID id);

        /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Verifica se existe uma Terceirizado com o ID passado por parâmetro
     * na base de dados.
     * @param id O id do Terceirizado a ser consultado.
     * @return 'true' caso haja um Terceirizado com o Id
     * passado por parâmetro na base de dados,
     * 'false' caso contrário.
     */
    boolean existsById(UUID id);

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra uma Terceirizado pelo ID passado por parâmetro.
     * @param id O ID da Terceirizado a ser enconotrado.
     * @return um objeto opcional do tipo Terceirizado,
     * que será nulo caso o Terceirizado não exista na base de dados.
     */
    Optional<Terceirizado> findById(UUID id);
}
