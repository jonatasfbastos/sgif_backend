package br.com.ifba.tipoTurma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.tipoTurma.model.TipoTurma;

public interface IDaoTipoTurma extends JpaRepository<TipoTurma, Long>{
    public abstract List<TipoTurma> findByNome(String nome);
    public boolean existsByNome(String nome);
}
