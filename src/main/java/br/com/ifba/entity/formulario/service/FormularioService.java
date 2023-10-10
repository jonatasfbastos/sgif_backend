package br.com.ifba.entity.formulario.service;

import br.com.ifba.entity.avaliacao.dao.IDaoAvaliacao;
import br.com.ifba.entity.avaliacao.model.Avaliacao;
import java.util.List;

import br.com.ifba.entity.formulario.model.Formulario;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.ifba.entity.formulario.dao.IDaoFormulario;
import br.com.ifba.infrastructure.exception.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class ServiceFormulario implements IServiceFormulario {

    //mensagem de erro caso o Formulario seja nulo;
    public final static String FORMULARIO_NULL = "Dados do Formulario nao preenchidos";

    //mensagem de erro caso o Formulario jÃ¡ exista no banco de dados;
    public final static String FORMULARIO_EXISTE = "Formulario ja existente no Banco de dados";

    //mensagem de erro caso o Formulario nÃ£o exista no banco de dados;
    public final static String FORMULARIO_NAO_EXISTE = "Formulario nao existente no Banco de dados";

    //mensagem de erro caso o Formulario seja invÃ¡lido;
    public final static String FORMULARIO_INVALIDO = "As informacoes do Formulario nao sao validas";
    
    //mensagem de erro caso o Formulario seja invÃ¡lido;
    public final static String CAMPO_VAZIO = "Campos nao preenchidos";
    
    //mensagem de erro em remoção de Formulário que tenha uma Avaliação atrelada
    public final static String IMPOSSIVEL_REMOVER = "Existe uma avaliacao atrelada ao formulario";

    //-_-_-_-_-_-_-_-_-_- OBJETO -_-_-_-_-_-_-_-_-_-
    @Autowired
    private IDaoFormulario formularioDao;
    
    @Autowired
    private IDaoAvaliacao avaliacaoDao;

    //-_-_-_-_-_-_-_-_-_- MÃ‰TODOS -_-_-_-_-_-_-_-_-_-
    @Override
    public Formulario saveFormulario(Formulario formulario) {
        if (formulario == null) {
            throw new BusinessException(FORMULARIO_NULL);
        }
        if (formulario.getTitulo().isEmpty() || formulario.getDescricao().isEmpty()) {
            throw new BusinessException(CAMPO_VAZIO);
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

    /*
    @Override
    public void deleteFormulario(Formulario formulario) {
        if (formulario == null) {
            throw new BusinessException(FORMULARIO_NULL);
        } else if (this.formularioDao.existsById(formulario.getId()) == true) {
            Avaliacao avaliacao = formulario.getAvaliacao();
            if (avaliacao.equals(this.avaliacaoDao.getReferenceById(avaliacao.getId()))) {
                throw new BusinessException(IMPOSSIVEL_REMOVER);
            } else {
                this.formularioDao.delete(formulario);
            }
        }
        throw new BusinessException(FORMULARIO_NAO_EXISTE);
    }
    */
    
    @Override
    public void deleteFormulario(Long id) {
        if (this.formularioDao.existsById(id) == false) {
            throw new BusinessException(FORMULARIO_NAO_EXISTE);
        }
        Avaliacao avaliacao = this.formularioDao.getReferenceById(id).getAvaliacao();
        if (avaliacao.equals(this.avaliacaoDao.getReferenceById(avaliacao.getId()))) {
            throw new BusinessException(IMPOSSIVEL_REMOVER);
        } else {
            this.formularioDao.delete(formularioDao.getReferenceById(id));
        }
    }

    @Override
    public List<Formulario> getAllFormulario() {
        return this.formularioDao.findAll();
    }

    @Override
    public Formulario findById(Long id) {
        return formularioDao.getReferenceById(id);
    }

    @Override
    public List<Formulario> findByTitulo(String titulo) {
        if (titulo == null) {
            throw new BusinessException("Dados do titulo nao preenchidos");
        } else if (titulo.isEmpty()) {
            throw new BusinessException("O Campo titulo esta vazio");
        } else {
            return formularioDao.findByTitulo(titulo);
        }
    }
}
