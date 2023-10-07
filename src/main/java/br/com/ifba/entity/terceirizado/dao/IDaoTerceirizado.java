package br.com.ifba.entity.terceirizado.dao;

import java.util.List;

import br.com.ifba.entity.terceirizado.model.Terceirizado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDaoTerceirizado extends JpaRepository<Terceirizado, Long> {
    List<Terceirizado> findByNome(String nome);
    boolean existsByNome(String nome);
    List<Terceirizado> findFuncaoTerceirizadoById(Long id);
}
