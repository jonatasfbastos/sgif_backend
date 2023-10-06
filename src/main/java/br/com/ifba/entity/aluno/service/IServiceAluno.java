package br.com.ifba.entity.aluno.service;

import java.util.List;

import br.com.ifba.entity.aluno.model.Aluno;

public interface IServiceAluno {
    
    public abstract Aluno saveAluno(Aluno professor);

    public abstract Aluno updateAluno(Aluno professor);

    public abstract void deleteAluno(Aluno professor);

    public abstract List<Aluno> getAllaluno();
    
    public List<Aluno> findByStatusAlunoId(Long id);

}