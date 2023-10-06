package br.com.ifba.entity.funcaoservidor.dao;

import br.com.ifba.entity.funcaoservidor.model.FuncaoServidor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDaoFuncaoServidor extends JpaRepository<FuncaoServidor, Long> {

}