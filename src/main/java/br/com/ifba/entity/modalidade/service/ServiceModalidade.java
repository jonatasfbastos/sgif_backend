package br.com.ifba.entity.modalidade.service;

import java.util.List;
import br.com.ifba.entity.curso.dao.IDaoCurso;
import br.com.ifba.entity.item.dao.IDaoItem;
import br.com.ifba.entity.modalidade.dao.IDaoModalidade;
import br.com.ifba.entity.modalidade.dto.ModalidadeResponseDto;
import br.com.ifba.entity.modalidade.model.Modalidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
/**
 * Service que fornece operações relacionadas a Modalidade.
 *
 * @author unknown
 * @since V1.0.1
 * @Editado por Andesson Reis
 */
@Service
public class ServiceModalidade implements IServiceModalidade{

    // =========================================================== //
    // ======================== [ ATRIBUTOS ] ==================== //
    // =========================================================== //

   @Autowired
    private IDaoModalidade modalidadeDao;

    @Autowired
    private IDaoCurso cursoDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // ======================== [ MÉTODOS ] ====================== //
    // =========================================================== //

    /**
     * Salva uma Modalidade na base de dados e retorna um objeto DTO com os dados resumidos da Modalidade salva.
     *
     * @param modalidade - A Modalidade que será salva na base de dados.
     * @return um objeto DTO com os dados resumidos da Modalidade salva.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public ModalidadeResponseDto saveModalidade(Modalidade modalidade) {
        
        return objectMapperUtil.map(
                modalidadeDao.save(modalidade),
                ModalidadeResponseDto.class);
    }


    @Override
    public Modalidade updateModalidade(Modalidade modalidade) {
        if(modalidade == null){
            throw new BusinessException(MODALIDADE_NULL);
        } else if(modalidadeDao.existsById(modalidade.getId()) == false) {
            throw new BusinessException(MODALIDADE_NAO_EXISTE);
        } else {
            return modalidadeDao.save(modalidade);
        }    
    }

    @Override
    public void deleteModalidade(Modalidade modalidade) {
        if(modalidade == null){
            throw new BusinessException(MODALIDADE_NULL);
        }else if(this.modalidadeDao.existsById(modalidade.getId()) == true) {
            this.modalidadeDao.delete(modalidade);
            return;
        }else if(modalidadeDao.getReferenceById(modalidade.getId()).getCursos().isEmpty() == false){
            throw new BusinessException(CURSO_EXISTE);
        }
            throw new BusinessException(MODALIDADE_NAO_EXISTE);    
}

    @Override
    public List<Modalidade> getAllModalidade() {
        return this.modalidadeDao.findAll();    
    }
    
    @Override
    public Modalidade findById(Long id) {
        return modalidadeDao.getReferenceById(id);
    }  

    @Override
    public List<Modalidade> findByNome(String nome) {
        if(nome == null) {
            throw new BusinessException("Dados do nome nao preenchidos");
        } else if(nome.isEmpty()) {
            throw new BusinessException("O Campo Nome esta vazio");
        } else {
            return modalidadeDao.findByNome(nome);
        }
    }
}