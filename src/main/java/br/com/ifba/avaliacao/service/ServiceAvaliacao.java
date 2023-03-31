package br.com.ifba.avaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.avaliacao.dao.IDaoAvaliacao;
import br.com.ifba.avaliacao.model.Avaliacao;
import br.com.ifba.infrastructure.exception.BusinessException;

@Service
public class ServiceAvaliacao implements IServiceAvaliacao{
    
    //================= CONSTANTES =============================================
    
    // Mensagem de erro se Avaliacao for null.
    public final static String AVALIACAO_NULL = "Dados da Avaliacao nao preenchidos";
    
    // Mensagem de erro se  Avaliacao jÃ¡ existe.
    public final static String AVALIACAO_EXISTE = "Avaliacao ja existente no Banco de dados";
    
    // Mensagem de erro se Avaliacao nÃ£o existir no banco.
    public final static String AVALIACAO_NAO_EXISTE = "AvaliaÃ§ao nao existente no Banco de dados";
    
    // Mensagem de erro se Avaliacao for invÃ¡lida.
    public final static String AVALIACAO_INVALIDO = "As informaÃ§oes da Avaliacao nao sao validas";
    
    
     //================= OBJETO =================================================
    @Autowired
    private IDaoAvaliacao avaliacaoDao;

     //================= MÃ‰TODOS ================================================
    @Override
    public Avaliacao saveAvaliacao(Avaliacao avaliacao) {
       if(avaliacao == null) {
            throw new BusinessException(AVALIACAO_NULL);
        } 
      
       return avaliacaoDao.save(avaliacao);
    }

    @Override
    public Avaliacao updateAvaliacao(Avaliacao avaliacao) {
        if(avaliacao == null) {
            throw new BusinessException(AVALIACAO_NULL);
        }
        if(avaliacaoDao.existsById(avaliacao.getId()) == false) {
            throw new BusinessException(AVALIACAO_NAO_EXISTE);
        }
        return avaliacaoDao.save(avaliacao);
    }

    @Override
    public void deleteAvaliacao(Avaliacao avaliacao) {
        if(avaliacao == null) {
            throw new BusinessException(AVALIACAO_NULL);
        }
        if(avaliacaoDao.existsById(avaliacao.getId()) == false) {
            throw new BusinessException(AVALIACAO_NAO_EXISTE);
        }
        avaliacaoDao.delete(avaliacao);
    }

    @Override
    public List<Avaliacao> getAllAvaliacao() {
        return this.avaliacaoDao.findAll();
    }
    
    
     @Override
     public Avaliacao findById(Long id) {
          return avaliacaoDao.getReferenceById(id);
     }
    
}
