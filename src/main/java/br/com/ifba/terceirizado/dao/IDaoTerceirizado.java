package br.com.ifba.terceirizado.dao;

import br.com.ifba.funcaoterceirizado.model.FuncaoTerceirizado;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.terceirizado.model.Terceirizado;

public interface IDaoTerceirizado extends JpaRepository<Terceirizado, Long> {
    public List<Terceirizado> findByNome(String nome);
    public boolean existsByNome(String nome);
    public List<Terceirizado> findFuncaoTerceirizadoById(Long id);
}
