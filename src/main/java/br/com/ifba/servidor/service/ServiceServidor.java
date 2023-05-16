package br.com.ifba.servidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.servidor.dao.IDaoServidor;
import br.com.ifba.servidor.model.Servidor;

@Service
public class ServiceServidor implements IServiceServidor{
    //================= CONSTANTES =============================================
    
    // Mensagem de erro se o Tecnico Administrativo for null.
    public final static String TECNICO_ADM_NULL = "Dados do Tecnico Administrativo nao preenchidos";
    
    // Mensagem de erro se o Tecnico Administrativo já existe.
    public final static String TECNICO_ADM_EXISTE = "Tecnico Administrativo ja existente no Banco de dados";
    
    // Mensagem de erro se o Tecnico Administrativo não existir no banco.
    public final static String TECNICO_ADM_NAO_EXISTE = "Tecnico Administrativo nao existente no Banco de dados";
    
    // Mensagem de erro se o Tecnico Administrativo for inválido.
    public final static String TECNICO_ADM_INVALIDO = "As informaçoes do Tecnico Administrativo nao sao validas";
    
     // Mensagem de erro caso o nome esteja vazio.
    private final static String NOME_VAZIO = "O Campo Nome esta vazio";
    
    // Mensagem de erro caso o nome seja null.
    private final static String NOME_NULL = "Dados do nome nao preenchidos";
    
    // Mensagem que foi deletado.
    private final static String TECNICO_DELETA = "Tecnico administrativo deletada com sucesso";
    
   
     //================= OBJETO =================================================
    @Autowired
    private IDaoServidor servidorDao;

     //================= MÉTODOS ================================================
    @Override
    public Servidor saveServidor(Servidor servidor) {
       if(servidor == null) {
            throw new BusinessException(TECNICO_ADM_NULL);
        } 
       if(servidorDao.existsById(servidor.getId()) == true) {
            throw new BusinessException(TECNICO_ADM_EXISTE);
        }
       return servidorDao.save(servidor);
    }

    @Override
    public Servidor updateTecincoAdministrativo(Servidor servidor) {
        if(servidor == null) {
            throw new BusinessException(TECNICO_ADM_NULL);
        }
        if(servidorDao.existsById(servidor.getId()) == false) {
            throw new BusinessException(TECNICO_ADM_NAO_EXISTE);
        }
        return servidorDao.save(servidor);
    }

    @Override
    public String deleteServidor(Long id) {
        if (servidorDao.existsById(id) == false) {
            throw new BusinessException(TECNICO_ADM_NAO_EXISTE);
        }
        servidorDao
                .delete(servidorDao.getReferenceById(id));
        return TECNICO_DELETA;
    }

    @Override
    public List<Servidor> getAllServidor() {
        return this.servidorDao.findAll();
    }
    
    @Override
    public List<Servidor> findByNome(String nome) {
        if(nome == null) {
            throw new BusinessException(NOME_NULL);
        }
        if(nome.isEmpty()) {
            throw new BusinessException(NOME_VAZIO);
        }
        return servidorDao.findByNome(nome);
    }
    
     @Override
     public Servidor findById(Long id) {
          return servidorDao.getReferenceById(id);
     }

    
}
