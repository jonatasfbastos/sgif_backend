package br.com.ifba.entity.statusaluno.service;

import br.com.ifba.entity.aluno.dao.IDaoAluno;
import br.com.ifba.entity.statusaluno.dao.IDaoStatusAluno;
import br.com.ifba.entity.statusaluno.dto.StatusAlunoResponseDto;
import br.com.ifba.entity.statusaluno.model.StatusAluno;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

import java.util.List;
import java.util.UUID;

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



    /**
     * Atualiza o Status do Aluno na base de dados e retorna um objeto DTO com os dados resumidos do Status do Aluno atualizado.
     *
     * @param status - O Status do Aluno que será atualizado na base de dados.
     * @return um objeto DTO com os dados resumidos do Status do Aluno atualizado.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public StatusAlunoResponseDto updateStatus(StatusAluno status) {

        statusAlunoDao.findById(status.getId())
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        return objectMapperUtil.map(
                statusAlunoDao.save(status),
                StatusAlunoResponseDto.class);
    }


    /**
     * Deleta o Status do Aluno com base no ID.
     *
     * @param id - O ID do Status do Aluno a ser deletado.
     * @return um objeto DTO com os dados do Status do Aluno deletado.
     * 
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public StatusAlunoResponseDto deleteStatus(UUID id) {

        return this.statusAlunoDao.findById(id)
                .map(statusAluno -> {
                    statusAlunoDao.delete(statusAluno);
                    return objectMapperUtil.map(statusAluno, StatusAlunoResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * Obtém uma lista de todos os Status dos Alunos como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os Status dos Alunos.
     * @since V1.0.1
     */
    @Override
    public List<StatusAlunoResponseDto> getAllstatus() {
        
        return objectMapperUtil.mapAll(
                this.statusAlunoDao.findAll(),
                StatusAlunoResponseDto.class);
    }
    
}
