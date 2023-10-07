package br.com.ifba.entity.servidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.entity.aluno.model.Aluno;
import br.com.ifba.entity.servidor.dao.IDaoServidor;
import br.com.ifba.entity.servidor.model.Servidor;

@Service
public class ServiceServidor implements IServiceServidor{
    //================= CONSTANTES =============================================
    
    // Mensagem de erro se o Tecnico Administrativo for null.
    public final static String Servidor_NULL = "Dados do Servidor nao preenchidos";
    
    // Mensagem de erro se o Tecnico Administrativo já existe.
    public final static String Servidor_EXISTE = "Servidor ja existente no Banco de dados";
    
    // Mensagem de erro se o Tecnico Administrativo não existir no banco.
    public final static String Servidor_NAO_EXISTE = "Servidor nao existente no Banco de dados";
    
    // Mensagem de erro se o Tecnico Administrativo for inválido.
    public final static String Servidor_INVALIDO = "As informaçoes do Servidor nao sao validas";
    
   
     //================= OBJETO =================================================
    @Autowired
    private IDaoServidor servidorDao;

     //================= MÉTODOS ================================================
    @Override
    public Servidor saveServidor(Servidor servidor) {
       if(servidor == null) {
            throw new BusinessException(Servidor_NULL);
        } 
        if(servidorDao.existsById(servidor.getId()) == false) {
            throw new BusinessException(Servidor_NAO_EXISTE);
        }
       return servidorDao.save(servidor);
    }

    @Override
    public Servidor updateTecnicoAdministrativo(Servidor servidor) {
        if(servidor == null) {
            throw new BusinessException(Servidor_NULL);
        }
        if(servidorDao.findById(servidor.getId()) == null) {
            throw new BusinessException(Servidor_NAO_EXISTE);
        }
        return servidorDao.save(servidor);
    }


    @Override
    public void deleteServidor(Servidor servidor) {
        if (servidor == null) {
            throw new BusinessException(Servidor_NULL);
        } 
        if(servidorDao.existsById(servidor.getId()) == false) {
            throw new BusinessException(Servidor_NAO_EXISTE);
        }
      servidorDao.delete(servidor);
    
    }

    @Override
    public List<Servidor> getAllServidor() {
        return this.servidorDao.findAll();
    }

}
