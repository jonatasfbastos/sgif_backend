package br.com.ifba.entity.curso.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.entity.curso.dto.CursoResponseDto;
import br.com.ifba.entity.curso.dao.IDaoCurso;
import br.com.ifba.entity.curso.model.Curso;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.infrastructure.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Unknown
 * Editado por Giovane Neves
 * Desde V1.0.1
 */
@Service
public class CursoService implements ICursoService {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //
    
    //mensagem de erro caso o Curso seja nulo;
    public final static String CURSO_NULL = "Dados do Curso nao preenchidos";
    
    //mensagem de erro caso o Curso exista no banco de dados;
    public final static String CURSO_EXISTE = "Curso ja existente no Banco de dados";
    
    //mensagem de erro caso o Curso não exista no banco de dados;
    public final static String CURSO_NAO_EXISTE = "Curso nao existente no Banco de dados";

    // Mensagem de erro se o Curso possuir matriz curricular
    public final static String CURSO_POSSUI_MATRIZ_CURRICULAR = "Curso possui matriz curricular";

    
    @Autowired
     private IDaoCurso cursoDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     *
     * Lista todos os cursos cadastrados na base de dados.
     * @return uma lista com todos os cursos da base de dados.
     */
    @Override
    public List<CursoResponseDto> listarCursos() {

        return objectMapperUtil.mapAll(
                this.cursoDao.findAll(),
                CursoResponseDto.class
        );
    }

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     *
     * Busca o curso cadastrado na base de dados atrelado ao ID
     * passado por parâmetro.
     * @param id O ID do curso a ser buscado.
     * @return o curso atrelado ao ID passado por parâmetro.
     */
    @Override
    public CursoResponseDto encontrarCursoPorId(UUID id) {


        return objectMapperUtil.map(
                this.cursoDao.findById(id)
                        .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())),
                CursoResponseDto.class
        );

    }

    @Override
    public Curso salvarCurso(Curso curso) {
        if(curso == null){
            throw new BusinessException(CURSO_NULL);
        } else if(cursoDao.existsById(curso.getId()) == true){
            throw new BusinessException(CURSO_EXISTE);
        } else {
            return cursoDao.save(curso);
        }
    }

    @Override
    public Curso atualizarCurso(Curso curso) {
        if(curso == null){
            throw new BusinessException(CURSO_NULL);
        } else if(cursoDao.existsById(curso.getId()) == false) {
            throw new BusinessException(CURSO_NAO_EXISTE);
        } else {
            return cursoDao.save(curso);
        }
    }

    @Override
    public void deletarCurso(Curso curso) {
        if(curso == null){
            throw new BusinessException(CURSO_NULL);
        }else if(this.cursoDao.existsById(curso.getId()) == true) {
            if (curso.getMatrizesCurriculares() == null){
                throw new BusinessException(CURSO_POSSUI_MATRIZ_CURRICULAR);
            }
            this.cursoDao.delete(curso);
            return;
        }
            throw new BusinessException(CURSO_NAO_EXISTE);

}


}

    