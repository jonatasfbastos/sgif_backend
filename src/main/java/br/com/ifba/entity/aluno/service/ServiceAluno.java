package br.com.ifba.entity.aluno.service;

import java.util.List;

import br.com.ifba.entity.aluno.dao.IDaoAluno;
import br.com.ifba.entity.aluno.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;

@Service
public class ServiceAluno implements IServiceAluno{
    

    // =========================================================== //
    // =============== [       ATRIBUTOS        ] ================ //
    // =========================================================== //

    /**
     * Mensagem de erro se o aluno for nulo.
     */
    public final static String ALUNO_NULL = "Dados do Aluno nao preenchidos";

    /**
     * Mensagem de erro para caso o aluno já exista na base de dados.
     */
    public final static String ALUNO_EXISTE = "Aluno ja existente no Banco de dados";

    /**
     * Mensagem de erro para caso o aluno não exista na base de dados.
     */
    public final static String ALUNO_NAO_EXISTE = "Aluno não existente no Banco de dados";

    /**
     * Mensagem de erro para caso o aluno tenha informações inválidas.
     */
    public final static String ALUNO_INVALIDO = "As informações do Aluno não são válidas";

    /**
     * Reposítório da entidade 'aluno'.
     */
    @Autowired
    private IDaoAluno alunoDao;

    // =========================================================== //
    // =============== [       MÉTODOS          ] ================ //
    // =========================================================== //

    /**
     *
     * Salva um aluno na base de ddados.
     *
     * @param aluno - O Aluno que será salvo na base de dados.
     * @return os dados do aluno salvo na base de dados,
     * caso a operação ocorra com sucesso.
     *
     */
    @Override
    public Aluno salvarAluno(Aluno aluno) {
       if(aluno == null) {
            throw new BusinessException(ALUNO_NULL);
       } else{
            return alunoDao.save(aluno);
       }
    }

    /**
     *
     * Atualiza os dados de uma aluno existente na base de dados.
     *
     * @param aluno - O Aluno que terá os seus dados atualizados.
     * @return os dados atualizados do aluno.
     *
     */
    @Override
    public Aluno atualizarAluno(Aluno aluno) {
        if(aluno == null) {
            throw new BusinessException(ALUNO_NULL);
        } 
        if(alunoDao.existsById(aluno.getId()) == false) {
            throw new BusinessException(ALUNO_NAO_EXISTE);
        }
        return alunoDao.save(aluno);
    }

    /**
     *
     * Deleta um aluno da base de dados.
     *
     * @param aluno - O Aluno que será deletado da base de dados.
     *
     */
    @Override
    public void deletarAluno(Aluno aluno) {
        if(aluno == null) {
            throw new BusinessException(ALUNO_NULL);
        } 
        if(alunoDao.existsById(aluno.getId()) == false) {
            throw new BusinessException(ALUNO_NAO_EXISTE);
        }
        alunoDao.delete(aluno);
    }

    /**
     *
     * Lista todos os alunos presentes na base de dados.
     *
     * @return uma lista com todos os alunos da base de dados, ou nulo caso não existe nenhum.
     */
    @Override
    public List<Aluno> listarAlunos() {
        return this.alunoDao.findAll();
    }

    /**
     * AVISO: Temporariamente desabilitada enquanto não é entendida a sua utilidade.
     */
    @Override
    public List<Aluno> findByStatusAlunoId(Long id) {
        return alunoDao.findByStatusAlunoId(id);
    }
}
