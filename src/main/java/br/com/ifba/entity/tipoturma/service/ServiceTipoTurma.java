package br.com.ifba.entity.tipoturma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.entity.formulario.dto.FormularioSimpleResponseDto;
import br.com.ifba.entity.tipoturma.dao.IDaoTipoTurma;
import br.com.ifba.entity.tipoturma.dto.TipoTurmaResponseDto;
import br.com.ifba.entity.tipoturma.model.TipoTurma;

/**
 * Service que fornece operações relacionadas a Tipos de Turma.
 *
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
 */
@Service
public class ServiceTipoTurma implements IServiceTipoTurma{

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

     @Autowired
    private IDaoTipoTurma tipoTurmaDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;
    
    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //
    
    /**
     * Salva um Tipo de Turma na base de dados e retorna um objeto DTO com os dados resumidos do Tipo de Turma salvo.
     *
     * @param tipoTurma - O Tipo de Turma que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do Tipo de Turma salvo.
     * 
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public TipoTurmaResponseDto saveTipoTurma(TipoTurma tipoTurma) {

        return Optional.of(tipoTurma)
                .filter(tipo -> !this.tipoTurmaDao.existsByNome(tipo.getNome()))
                .map(tipo -> objectMapperUtil.map(this.tipoTurmaDao.save(tipo), TipoTurmaResponseDto.class))
                .orElseThrow(() -> new BusinessException(
                        BusinessExceptionMessage.ATTRIBUTE_VALUE_ALREADY_EXISTS.getMensagemValorJaExiste("Nome"))
                );


    }

    @Override
    public TipoTurma updateTipoTurma(TipoTurma tipoturma) {
        if(tipoturma == null){
            throw new BusinessException(TIPOTURMA_NULL);
        } 
        if(tipoturmaDao.existsById(tipoturma.getId()) == false) {
            throw new BusinessException(TIPOTURMA_NAO_EXISTE);
        }
        return this.tipoturmaDao.save(tipoturma);        
    }

    @Override
    public void deleteTipoTurma(TipoTurma tipoturma) {
        if(tipoturma == null){
            throw new BusinessException(TIPOTURMA_NULL);
        } 
        if(tipoturmaDao.existsById(tipoturma.getId()) == false) {
            throw new BusinessException(TIPOTURMA_NAO_EXISTE);
        }
        this.tipoturmaDao.delete(tipoturma);
    }

    @Override
    public List<TipoTurma> getAllTipoTurma() {
        return this.tipoturmaDao.findAll();
    }
    
    @Override
    public List<TipoTurma> findByNome(String nome) {
        if(nome == null) {
            throw new BusinessException(NOME_NULL);
        } 
        if(nome.isEmpty()) {
            throw new BusinessException(NOME_VAZIO);
        }
        return this.tipoturmaDao.findByNome(nome);
    }
    
     @Override
     public TipoTurma findById(Long id) {
          return this.tipoturmaDao.getReferenceById(id);
     }
     
}
