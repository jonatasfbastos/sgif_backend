package br.com.ifba.pessoa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.pessoa.model.Pessoa;

@Repository
public interface IDaoPessoa extends JpaRepository<Pessoa, Long> {

    public abstract List<Pessoa> findByNome(String name);

    public abstract Optional<Pessoa> findById(Long id);

    public abstract void delete(Pessoa pessoa);

    // public abstract Optional<Pessoa> findByLoginOrEmailAndSenha(String login,
    // String email, String senha);
}
