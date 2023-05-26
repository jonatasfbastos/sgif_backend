/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.funcaoterceirizado.service;

import br.com.ifba.funcaoterceirizado.dao.IDaoFuncaoTerceirizado;
import br.com.ifba.funcaoterceirizado.model.FuncaoTerceirizado;
import br.com.ifba.infrastructure.exception.BusinessException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ph715
 */
@Service
public class ServiceFuncaoTerceirizado implements IServiceFuncaoTerceirizado{
    private final static String FUNCAO_NULL = "A função do técnico está vazia, preencha e tente novamente.";
    private final static String FUNCAO_NAO_EXISTE = "A função informada não existe.";
    private final static String FUNCAO_DELETADA = "Função deletada com sucesso.";
    private final static String CAMPO_VAZIO = "Há campo vazio, preencha e tente novamente.";
    
    @Autowired
    private IDaoFuncaoTerceirizado daoFuncaoTerceirizado;

    @Override
    public FuncaoTerceirizado saveFuncaoTerceirizado(FuncaoTerceirizado funcaoTerceirizado) {
        if(funcaoTerceirizado == null){
            throw new BusinessException(FUNCAO_NULL);
        }
        if(funcaoTerceirizado.getNome().isEmpty() || funcaoTerceirizado.getDescricao().isBlank()){
            throw new BusinessException(CAMPO_VAZIO);
        }
        return daoFuncaoTerceirizado.save(funcaoTerceirizado);
    }

    @Override
    public String deleteFuncaoTerceirizado(Long id) {
        if(daoFuncaoTerceirizado.existsById(id) == false){
            throw new BusinessException(FUNCAO_NAO_EXISTE);
        }
        daoFuncaoTerceirizado.delete(daoFuncaoTerceirizado.getReferenceById(id));
        return FUNCAO_DELETADA;
    }

    @Override
    public List<FuncaoTerceirizado> getAllFuncoesTerceirizado() {
        return daoFuncaoTerceirizado.findAll();
    }
    
}
