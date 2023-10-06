package br.com.ifba.entity.disciplina.service;

import java.util.List;

import br.com.ifba.entity.disciplina.model.Disciplina;
import org.springframework.stereotype.Service;

@Service
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
