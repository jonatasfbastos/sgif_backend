package br.com.ifba.entity.terceirizado.service;

import java.util.List;

import br.com.ifba.entity.terceirizado.model.Terceirizado;

public interface IServiceTerceirizado {
    public abstract Terceirizado saveTerceirizado(Terceirizado terceirizado);
    
    public abstract Terceirizado updateTerceirizado(Terceirizado terceirizado);
    
    public abstract void deleteTerceirizado(Terceirizado terceirizado);
     
    public abstract List<Terceirizado> getAllterceirizado();
    
    public Terceirizado findById(Long id);
   
    public List<Terceirizado> findByNome(String nome);
    
    public List<Terceirizado> getByFuncao(Long id);
}
