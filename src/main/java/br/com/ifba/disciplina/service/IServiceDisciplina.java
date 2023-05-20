package br.com.ifba.disciplina.service;

import java.util.List;

import br.com.ifba.disciplina.model.Disciplina;

public interface IServiceDisciplina {
    //salva a disciplina
    public abstract Disciplina saveDisciplina(Disciplina disciplina);
    
    //deleta a disciplina
    public abstract void deleteDisciplina(Disciplina disciplina);
    
    //atualiza a disciplina
    public abstract Disciplina updateDisciplina(Disciplina disciplina);
    
    // Metodo que retorna todas oas disciplinas da base de dados
    public abstract List<Disciplina> getAllDisciplina();
    
    // Procura disciplina por nome
    public List<Disciplina> findByNome(String nome);

    // Procura disciplina por id
    public Disciplina findById(Long id);
    
}
