package br.com.ifba.curso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ifba.curso.model.Curso;

@Service
public interface IServiceCurso {
    
    public abstract Curso saveCurso(Curso curso);
    
    //atualiza Curso
    public abstract Curso updateCurso(Curso curso);
    
    //deleta Curso
    public abstract void deleteCurso(Curso curso);
    
    // Metodo que retorna todos os Cursos da base de dados
    public abstract List<Curso> getAllCurso();
    
    // Metodo que procura curso pelo id
    public Curso findById (Long id);
    
}
