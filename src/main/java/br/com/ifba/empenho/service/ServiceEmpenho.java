/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.empenho.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ifba.empenho.dao.IDaoEmpenho;
import br.com.ifba.empenho.model.Empenho;
import br.com.ifba.infrastructure.exception.BusinessException;

/**
 *
 * @author rocki.julius
 */
@Service
public class ServiceEmpenho implements IServiceEmpenho {

    // Constantes para condições de erro

    // Empenho Null
    public final static String empenho_NULL = "Empenho null";

    // Empenho já existe
    public final static String empenho_EXISTE = "Empenho já existe";

    // Empenho não existente
    public final static String empenho_NAO_EXISTE = "O empenho já existe na base de dados";

    // Empenho inválido
    public final static String empenho_INVALIDO = "Empenho inválido";

    // Criando objeto de instância
    @Autowired
    private IDaoEmpenho daoEmpenho;

    @Override
    public Empenho saveEmpenho(Empenho empenho) {
        if (empenho == null) {
            throw new BusinessException(empenho_NULL);
        } else {
            return daoEmpenho.save(empenho);
        }
    }

    @Override
    public Empenho updateEmpenho(Empenho empenho) {
        if (empenho == null) {
            throw new BusinessException(empenho_NULL);
        } else if (daoEmpenho.findById(empenho.getId()) == null) {
            throw new BusinessException(empenho_EXISTE);
        } else {
            return daoEmpenho.save(empenho);
        }
    }

    @Override
    public void deleteEmpenho(Empenho empenho) {
        if (empenho == null) {
            throw new BusinessException(empenho_NULL);
        } else {
            this.daoEmpenho.delete(empenho);
            return;
        }
    }

    @Override
    public List<Empenho> getAllEmpenho() {
        return daoEmpenho.findAll();
    }

}
