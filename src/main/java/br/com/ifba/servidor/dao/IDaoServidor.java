package br.com.ifba.servidor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.servidor.model.Servidor;

public interface IDaoServidor extends JpaRepository<Servidor, Long>{
    
    
}
