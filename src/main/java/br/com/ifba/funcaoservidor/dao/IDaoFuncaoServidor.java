package br.com.ifba.funcaoservidor.dao;

import br.com.ifba.funcaoservidor.model.FuncaoServidor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDaoFuncaoServidor extends JpaRepository<FuncaoServidor, Long> {

    boolean existsByNome(String nome);
    boolean existsById(Long id);

}