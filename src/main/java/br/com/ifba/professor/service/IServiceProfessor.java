package br.com.ifba.professor.service;

import java.util.List;

import br.com.ifba.professor.model.Professor;

public interface IServiceProfessor {
    
    // Salva professor.
    public abstract Professor saveProfessor(Professor professor);
    // Atualiza professor.
    public abstract Professor updateProfessor(Professor professor);
    // Deleta professor.
    public abstract void deleteProfessor(Professor professor);
     // MÃ©todo que retorna todos os professores da base de dados.
    public abstract List<Professor> getAllprofessor();
    // MÃ©todo que retorna o professor com o id informado.
    public Professor findById(Long id);
    // MÃ©todo que retorna a lista com os professores com o nome informado.
    public List<Professor> findByNome(String nome);
}
