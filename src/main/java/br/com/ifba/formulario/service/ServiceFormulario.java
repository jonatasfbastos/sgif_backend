package br.com.ifba.formulario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.formulario.dao.IDaoFormulario;
import br.com.ifba.formulario.model.Formulario;
import br.com.ifba.infrastructure.exception.BusinessException;

@Service
public class ServiceFormulario implements IServiceFormulario {

    //mensagem de erro caso o Formulario seja nulo;
    public final static String FORMULARIO_NULL = "Dados do Formulario nao preenchidos";

    //mensagem de erro caso o Formulario jÃ¡ exista no banco de dados;
    public final static String FORMULARIO_EXISTE = "Formulario ja existente no Banco de dados";

    //mensagem de erro caso o Formulario nÃ£o exista no banco de dados;
    public final static String FORMULARIO_NAO_EXISTE = "Formulario nao existente no Banco de dados";

    //mensagem de erro caso o Formulario seja invÃ¡lido;
    public final static String FORMULARIO_INVALIDO = "As informaÃ§oes do Formulario nao sao validas";

    //-_-_-_-_-_-_-_-_-_- OBJETO -_-_-_-_-_-_-_-_-_-
    @Autowired
    private IDaoFormulario formularioDao;

    //-_-_-_-_-_-_-_-_-_- MÃ‰TODOS -_-_-_-_-_-_-_-_-_-
    @Override
    public Formulario saveFormulario(Formulario formulario) {
        if (formulario == null) {
            throw new BusinessException(FORMULARIO_NULL);
        } else if (formularioDao.existsById(formulario.getId()) == true) {
            throw new BusinessException(FORMULARIO_EXISTE);
        } else {
            return formularioDao.save(formulario);
        }
    }

    @Override
    public Formulario updateFormulario(Formulario formulario) {
        if (formulario == null) {
            throw new BusinessException(FORMULARIO_NULL);
        } else if (formularioDao.existsById(formulario.getId()) == false) {
            throw new BusinessException(FORMULARIO_NAO_EXISTE);
        } else {
            return formularioDao.save(formulario);
        }
    }

    @Override
    public void deleteFormulario(Formulario formulario) {
        if (formulario == null) {
            throw new BusinessException(FORMULARIO_NULL);
        } else if (this.formularioDao.existsById(formulario.getId()) == true) {
            this.formularioDao.delete(formulario);
            return;
        }
        throw new BusinessException(FORMULARIO_NAO_EXISTE);
    }
    
    @Override
    public void deleteFormularioPorID(Long id) {
        if (formularioDao.existsById(id) == false) {
            throw new BusinessException(FORMULARIO_NAO_EXISTE);
        }
        formularioDao.delete(formularioDao.getReferenceById(id));
    }

    @Override
    public List<Formulario> getAllFormulario() {
        return this.formularioDao.findAll();
    }

    @Override
    public Formulario findById(Long id) {
        return formularioDao.getReferenceById(id);
    }

    
}
