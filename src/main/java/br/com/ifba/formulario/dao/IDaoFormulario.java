package br.com.ifba.formulario.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.formulario.model.Formulario;


public interface IDaoFormulario extends JpaRepository<Formulario, Long>{
    
    

}
