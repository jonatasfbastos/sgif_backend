package br.com.ifba.etapacurso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.etapacurso.dao.IDaoEtapaCurso;
import br.com.ifba.etapacurso.model.EtapaCurso;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.turma.dao.IDaoTurma;

@Service
public class ServiceEtapaCurso implements IServiceEtapaCurso{
    // Mensagem de erro se o EtapaCurso for null
    private final static String ETAPA_CURSO_NULL = "Dados de Etapa Curso nao preenchidos";
    // Mensagem de erro se o EtapaCurso jÃ¡ existir
    private final static String ETAPA_CURSO_EXISTE = "Etapa Curso ja existente no Banco de dados";
    // Mensagem de erro se a EtapaCurso nÃ£o existir no banco
    private final static String ETAPA_CURSO_NAO_EXISTE = "Etapa Curso nao existente no Banco de dados";
    // Mensagem de erro caso o nome esteja vazio
    private final static String NOME_VAZIO = "O Campo Nome esta vazio";
    // Mensagem de erro caso o nome seja null
    private final static String NOME_NULL = "Dados do nome nao preenchidos";
    //mensagem de erro caso exista turma
    private final static String TURMA_EXISTE = "Etapa Curso não pode ser excluiída com Turma";
    
     //================= OBJETO =================================================
    @Autowired
    private IDaoEtapaCurso etapaCursoDao;
    private IDaoTurma turmaDao;

     //================= MÃ‰TODOS ================================================
    @Override
    public EtapaCurso saveEtapaCurso(EtapaCurso etapaCurso) {
       if(etapaCurso == null){
            throw new BusinessException(ETAPA_CURSO_NULL);
        }
       if(etapaCursoDao.existsByNome(etapaCurso.getNome()) == true) {
            throw new BusinessException(ETAPA_CURSO_EXISTE);
        }
       return this.etapaCursoDao.save(etapaCurso);
    }

    @Override
    public EtapaCurso updateEtapaCurso(EtapaCurso etapaCurso) {
        if(etapaCurso == null){
            throw new BusinessException(ETAPA_CURSO_NULL);
        } 
        if(etapaCursoDao.existsById(etapaCurso.getId()) == false) {
            throw new BusinessException(ETAPA_CURSO_NAO_EXISTE);
        }
        return this.etapaCursoDao.save(etapaCurso);        
    }

    @Override
    public void deleteEtapaCurso(EtapaCurso etapaCurso) {
        if(etapaCurso == null){
            throw new BusinessException(ETAPA_CURSO_NULL);
        } 
        if(etapaCursoDao.existsById(etapaCurso.getId()) == false) {
            throw new BusinessException(ETAPA_CURSO_NAO_EXISTE);
        }
        if(etapaCursoDao.getReferenceById(etapaCurso.getId()).getTurma().isEmpty() == false) {
            throw new BusinessException(TURMA_EXISTE);
        }
        this.etapaCursoDao.delete(etapaCurso);
    }

    @Override
    public List<EtapaCurso> getAllEtapaCurso() {
        return this.etapaCursoDao.findAll();
    }
    
    @Override
    public List<EtapaCurso> findByNome(String nome) {
        if(nome == null) {
            throw new BusinessException(NOME_NULL);
        } 
        if(nome.isEmpty()) {
            throw new BusinessException(NOME_VAZIO);
        }
        return this.etapaCursoDao.findByNome(nome);
    }
    
     @Override
     public EtapaCurso findById(Long id) {
          return this.etapaCursoDao.getReferenceById(id);
     }
}
