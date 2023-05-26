package br.com.ifba.aluno.dao;
import br.com.ifba.aluno.model.Aluno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDaoAluno extends JpaRepository<Aluno, Long>{
    
    List<Aluno> findByStatusAlunoId(Long id);

}
