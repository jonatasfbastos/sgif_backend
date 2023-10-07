package br.com.ifba.entity.pessoa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.entity.pessoa.model.Pessoa;

@Repository
public interface IDaoPessoa extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByNome(String name);

    Optional<Pessoa> findById(Long id);

    void delete(Pessoa pessoa);

    // public abstract Optional<Pessoa> findByLoginOrEmailAndSenha(String login,
    // String email, String senha);
}
