package br.com.ifba.entity.formulario.dao;

import java.util.List;

import br.com.ifba.entity.formulario.model.Formulario;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IDaoFormulario extends JpaRepository<Formulario, Long>{
    
    List<Formulario> findByTitulo(String titulo);
    boolean existsByTitulo(String titulo);
    boolean existsById(Long id);

}
