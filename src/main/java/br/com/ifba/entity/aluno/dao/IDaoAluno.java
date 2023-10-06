package br.com.ifba.entity.aluno.dao;

import br.com.ifba.entity.aluno.model.Aluno;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDaoAluno extends JpaRepository<Aluno, Long>{
    
    List<Aluno> findByStatusAlunoId(Long id);

}
