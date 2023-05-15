package br.com.ifba.servidor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.servidor.model.Servidor;

public interface IDaoServidor extends JpaRepository<Servidor, Long>{
    
    public List<Servidor> findByNome(String nome);
    public boolean existsByNome(String nome);
}
