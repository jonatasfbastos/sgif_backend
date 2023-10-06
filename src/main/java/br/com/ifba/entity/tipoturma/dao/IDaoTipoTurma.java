package br.com.ifba.entity.tipoturma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.tipoturma.model.TipoTurma;

public interface IDaoTipoTurma extends JpaRepository<TipoTurma, Long>{
    public abstract List<TipoTurma> findByNome(String nome);
    public boolean existsByNome(String nome);
}
