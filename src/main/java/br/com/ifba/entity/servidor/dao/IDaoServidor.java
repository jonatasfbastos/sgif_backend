package br.com.ifba.entity.servidor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.servidor.model.Servidor;

public interface IDaoServidor extends JpaRepository<Servidor, Long>{
    
    
}
