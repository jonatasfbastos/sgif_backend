package br.com.ifba.formulario.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.formulario.model.Formulario;

@Repository
public interface IDaoFormulario extends JpaRepository<Formulario, Long>{
    
    public abstract List<Formulario> findByTitulo(String titulo);

}
