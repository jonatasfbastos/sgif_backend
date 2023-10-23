package br.com.ifba.entity.mensagem.service;

import br.com.ifba.entity.mensagem.model.Mensagem;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.entity.mensagem.dao.IDaoMensagem;
import br.com.ifba.entity.mensagem.dto.MensagemResponseDto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service que fornece operações relacionadas a Mensagem.
 *
 * @author felipe
 * @since V1.0.1
 * @Editado por Andesson Reis
 */
@Service
public class ServiceMensagem implements IServiceMensagem{
    // =========================================================== //
    // =============== [ ATRIBUTOS ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoMensagem mensagemDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ MÉTODOS ] ================== //
    // =========================================================== //
    

    /**
     * Salva uma Mensagem na base de dados e retorna um objeto DTO com os dados resumidos da Mensagem salva.
     *
     * @param mensagem - A Mensagem que será salva na base de dados.
     * @return um objeto DTO com os dados resumidos da Mensagem salva.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public MensagemResponseDto saveMensagem(Mensagem mensagem) {
        
        return objectMapperUtil.map(
                mensagemDao.save(mensagem),
                MensagemResponseDto.class);
    }
    @Override
    public Mensagem updateMensagem(Mensagem mensagem) {
        if(mensagem == null){
            throw new BusinessException(MENSAGEM_NULL);
        } 
        if(mensagemDao.existsById(mensagem.getId()) == false) {
            throw new BusinessException(MENSAGEM_NAO_EXISTE);
        }
        return this.mensagemDao.save(mensagem);        
    }

    @Override
    public void deleteMensagem(Mensagem mensagem) {
        if(mensagem == null){
            throw new BusinessException(MENSAGEM_NULL);
        } 
        if(mensagemDao.existsById(mensagem.getId()) == false) {
            throw new BusinessException(MENSAGEM_NAO_EXISTE);
        }
        this.mensagemDao.delete(mensagem);
    }

    @Override
    public List<Mensagem> getAllMensagem() {
        return this.mensagemDao.findAll();
    }
    
    @Override
    public List<Mensagem> findByNome(String nome) {
        if(nome == null) {
            throw new BusinessException(NOME_NULL);
        } 
        if(nome.isEmpty()) {
            throw new BusinessException(NOME_VAZIO);
        }
        return this.mensagemDao.findByNome(nome);
    }
    
     @Override
     public Mensagem findById(Long id) {
          return this.mensagemDao.getReferenceById(id);
     }
}


