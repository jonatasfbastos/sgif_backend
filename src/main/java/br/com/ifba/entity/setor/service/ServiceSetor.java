/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.entity.setor.service;

import java.util.List;

import br.com.ifba.entity.setor.dao.IDaoSetor;
import br.com.ifba.entity.setor.model.Setor;
import br.com.ifba.infrastructure.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Everton.
 */
@Service
public class ServiceSetor implements IServiceSetor {

    // CONSTANTES

    // mensagem de erro se o setor for null;
    public final static String SETOR_NULL = "Setor null";

    // mensagem de erro se o setor já existir;
    public final static String SETOR_EXISTE = "O Setor já existe,";

    // mensagem de erro se o setor não existir no banco;
    public final static String SETOR_NAO_EXISTE = "O Setor não existe na base de dados";

    // mensagem de erro se o setor for inválido;
    public final static String SETOR_INVALIDO = "Setor inválido";

    // Objeto
    @Autowired
    private IDaoSetor daoSetor;

    @Override
    public Setor saveSetor(Setor setor) {
        if (setor == null) {
            throw new BusinessException(SETOR_NULL);
        } else {
            return daoSetor.save(setor);
        }
    }

    @Override
    public Setor updateSetor(Setor setor) {
        if (setor == null) {
            throw new BusinessException(SETOR_NULL);
        } else if (daoSetor.findById(setor.getId()) == null) {
            throw new BusinessException(SETOR_NAO_EXISTE);
        } else {
            return daoSetor.save(setor);
        }
    }

    @Override
    public void deleteSetor(Setor setor) {
        if (setor == null) {
            throw new BusinessException(SETOR_NULL);
        } else {
            daoSetor.delete(setor);
        }
    }

    @Override
    public List<Setor> getAllSetor() {
        return this.daoSetor.findAll();
    }

}
