/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.checkbox.service;

import br.com.ifba.checkbox.dao.IDaoCheckBox;
import br.com.ifba.checkbox.model.CheckBox;
import br.com.ifba.infrastructure.exception.BusinessException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ellen Cristina
 */
public class ServiceCheckBox implements IServiceCheckBox{
    // Mensagem de erro se o CheckBox for null.
    public final static String CHECKBOX_NULL = "Dados do CheckBox nao preenchidos";
    // Mensagem de erro se o CheckBox já existir.
    public final static String CHECKBOX_EXISTE = "CheckBox ja existente no Banco de dados";
    // Mensagem de erro se o CheckBox não existir no banco.
    public final static String CHECKBOX_NAO_EXISTE = "CheckBox nao existente no Banco de dados";
    // Mensagem de erro se o CheckBox for inválido.
    public final static String CHECKBOX_INVALIDO = "As informações do CheckBox nao sao validas";
     
    
     //================= OBJETO =================================================
    @Autowired
    private IDaoCheckBox checkBoxDao;

     //================= MÉTODOS ================================================
    @Override
    public CheckBox saveCheckBox(CheckBox checkbox) {
       if(checkbox == null) {
            throw new BusinessException(CHECKBOX_NULL);
       } else{
            return checkBoxDao.save(checkbox);
       }
    }

    @Override
    public CheckBox updateCheckBox(CheckBox checkbox) {
        if(checkbox == null) {
            throw new BusinessException(CHECKBOX_NULL);
        } 
        if(checkBoxDao.existsById(checkbox.getId()) == false) {
            throw new BusinessException(CHECKBOX_NAO_EXISTE);
        }
        return checkBoxDao.save(checkbox);
    }

    @Override
    public void deleteCheckBox(CheckBox checkbox) {
        if(checkbox == null) {
            throw new BusinessException(CHECKBOX_NULL);
        } 
        if(checkBoxDao.existsById(checkbox.getId()) == false) {
            throw new BusinessException(CHECKBOX_NAO_EXISTE);
        }
        checkBoxDao.delete(checkbox);
    }

    @Override
    public List<CheckBox> getAllCheckBox() {
        return this.checkBoxDao.findAll();
    }
    
}
