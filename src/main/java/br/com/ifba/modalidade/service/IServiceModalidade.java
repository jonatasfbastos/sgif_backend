package br.com.ifba.modalidade.service;

import java.util.List;

import br.com.ifba.modalidade.model.Modalidade;

public interface IServiceModalidade {
    //salva a Modalidade
    public abstract Modalidade saveModalidade(Modalidade modalidade);
    
    //atualiza a Modalidade
    public abstract Modalidade updateModalidade(Modalidade modalidade);
    
    //deleta a Modalidade
    public abstract void deleteModalidade(Modalidade modalidade);
    
    // Metodo que retorna todas as Modalidades da base de dados
    public abstract List<Modalidade> getAllModalidade();
    
    // Metodo que retorna a Modalidade com o id informado
    public Modalidade findById(Long id);
    
    // Metodo que retorna a lista com as Modalidades com o nome informado
    public List<Modalidade> findByNome(String nome);
}
