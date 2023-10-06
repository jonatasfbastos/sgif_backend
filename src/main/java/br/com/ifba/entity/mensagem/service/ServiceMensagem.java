/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.entity.mensagem.service;

import br.com.ifba.entity.mensagem.model.Mensagem;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.entity.mensagem.dao.IDaoMensagem;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author felipe
 */
@Service
public class ServiceMensagem implements IServiceMensagem{
    // Mensagem de erro se a Mensagem for null
    private final static String MENSAGEM_NULL = "Dados da Mensagem nao preenchidos";
    // Mensagem de erro se a Mensagem ja existir
    private final static String MENSAGEM_EXISTE = "Mensagem ja existente no Banco de dados";
    // Mensagem de erro se a Mensagem nao existir no banco
    private final static String MENSAGEM_NAO_EXISTE = "Mensagem nao existente no Banco de dados";
    // Mensagem de erro caso o nome esteja vazio
    private final static String NOME_VAZIO = "O Campo Nome esta vazio";
    // Mensagem de erro caso o nome seja null
    private final static String NOME_NULL = "Dados do nome nao preenchidos";
    
    
     //================= OBJETO =================================================
    @Autowired
    private IDaoMensagem mensagemDao;

     //================= METODOS ================================================
    @Override
    public Mensagem saveMensagem(Mensagem mensagem) {
       if(mensagem == null){
            throw new BusinessException(MENSAGEM_NULL);
        }
       if(mensagemDao.existsByNome(mensagem.getNome()) == true) {
            throw new BusinessException(MENSAGEM_EXISTE);
        }
       return this.mensagemDao.save(mensagem);
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


