package br.com.ifba.turma.service;

import java.util.List;

import br.com.ifba.turma.model.Turma;

public interface IServiceTurma {
    
    public abstract Turma saveTurma(Turma turma);

    public abstract Turma updateTurma(Turma turma);

    public abstract void deleteTurma(Turma turma);

    public abstract List<Turma> getAllTurma();

}
