package br.com.ifba.aluno.dao;
import java.util.List;
import br.com.ifba.aluno.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDaoAluno extends JpaRepository<Aluno, Long>{
    
}
