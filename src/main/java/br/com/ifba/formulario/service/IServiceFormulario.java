package br.com.ifba.formulario.service;

import java.util.List;

import br.com.ifba.formulario.model.Formulario;

public interface IServiceFormulario {
    
    // Salva o Formulario
    public abstract Formulario saveFormulario(Formulario formulario);
    
    // Atualiza o Formulario
    public abstract Formulario updateFormulario(Formulario formulario);
    
    // Deleta o Formulario
    public abstract void deleteFormulario(Formulario formulario);
    
    // Deleta o formulário por id
    public abstract void deleteFormulario(Long id);
    
    // Metodo que retorna todos os Formularios da base de dados
    public abstract List<Formulario> getAllFormulario();
    
    // MÃ©todo que retorna o Formulario com o id informado
    public Formulario findById(Long id);
    
    // MÃ©todo que retorna a lista com os Formularios com o nome informado
    public List<Formulario> findByTitulo(String titulo);
    
}
