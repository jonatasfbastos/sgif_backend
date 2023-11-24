package br.com.ifba.sgif.api.entity.pessoa.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.pessoa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Unknown
 * Editado por Giovane Neves, Andesson Reis
 * @since Desde V1.0.1
 */
@Repository
public interface IDaoPessoa extends JpaRepository<Pessoa, UUID> {

    // =========================================================== //
    // =============== [ ASSINATURAS DE MÉTODOS ] ================ //
    // =========================================================== //

    List<Pessoa> findByNome(String name);

    Optional<Pessoa> findById(UUID id);

    void delete(Pessoa pessoa);

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * Verifica se há uma pessoa com o CPF passado por parâmetro
     * na base de dados.
     * @param cpf O CPF a ser consultado
     * @return 'true' caso haja uma pessoa com o CPF em questão,
     * 'false' caso contrário.
     */
    boolean existsByCpf(String cpf);
}
