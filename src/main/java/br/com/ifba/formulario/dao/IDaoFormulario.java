package br.com.ifba.formulario.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.formulario.model.Formulario;

@Repository
public interface IDaoFormulario extends JpaRepository<Formulario, Long>{
    
    List<Formulario> findByTitulo(String titulo);
    boolean existsByTitulo(String titulo);
    boolean existsById(Long id);

}
