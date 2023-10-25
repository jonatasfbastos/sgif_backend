package br.com.ifba.entity.statusaluno.service;

import br.com.ifba.entity.aluno.dao.IDaoAluno;
import br.com.ifba.entity.statusaluno.dao.IDaoStatusAluno;
import br.com.ifba.entity.statusaluno.dto.StatusAlunoResponseDto;
import br.com.ifba.entity.statusaluno.model.StatusAluno;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service que fornece operações relacionadas ao Status dos Alunos.
 *
 * @author Ellen Cristina
 * Editado por Andesson Reisa
 * @since V1.0.1
 */
@Service
public class ServiceStatusAluno implements IServiceStatusAluno{
    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoStatusAluno statusAlunoDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== /


    /**
     * Salva o Status do Aluno na base de dados e retorna um objeto DTO com os dados resumidos do Status do Aluno salvo.
     *
     * @param status - O Status do Aluno que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do Status do Aluno salvo.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public StatusAlunoResponseDto saveStatus(StatusAluno status) {
        
        return objectMapperUtil.map(
                statusAlunoDao.save(status),
                StatusAlunoResponseDto.class);
    }


    @Override
    public StatusAluno updateStatus(StatusAluno status) {
        if(status == null) {
            throw new BusinessException(STATUS_NULL);
        } 
        if(statusDao.existsById(status.getId()) == false) {
            throw new BusinessException(STATUS_NAO_EXISTE);
        }
        return statusDao.save(status);
    }

    @Override
    public void deleteStatus(StatusAluno status) {
        if(status == null) {
            throw new BusinessException(STATUS_NULL);
        } 
        if(statusDao.existsById(status.getId()) == false) {
            throw new BusinessException(STATUS_NAO_EXISTE);
        }
        if(statusDao.getReferenceById(status.getId()).getAlunos().isEmpty() == false){
            throw new BusinessException(ALUNO_EXISTE);
        }
        statusDao.delete(status);
    }

    @Override
    public List<StatusAluno> getAllstatus() {
        return this.statusDao.findAll();
    }
    
}
