package br.com.ifba.entity.terceirizado.dao;

import java.util.List;

import br.com.ifba.entity.terceirizado.model.Terceirizado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDaoTerceirizado extends JpaRepository<Terceirizado, Long> {
    public List<Terceirizado> findByNome(String nome);
    public boolean existsByNome(String nome);
    public List<Terceirizado> findFuncaoTerceirizadoById(Long id);
}
