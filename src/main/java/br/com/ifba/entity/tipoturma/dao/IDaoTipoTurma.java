package br.com.ifba.entity.tipoturma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.entity.tipoturma.model.TipoTurma;

@Repository
public interface IDaoTipoTurma extends JpaRepository<TipoTurma, Long>{

    List<TipoTurma> findByNome(String nome);
    boolean existsByNome(String nome);

}
