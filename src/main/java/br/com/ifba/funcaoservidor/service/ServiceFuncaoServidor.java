package br.com.ifba.funcaoservidor.service;

import br.com.ifba.funcaoservidor.dao.IDaoFuncaoServidor;
import br.com.ifba.funcaoservidor.model.FuncaoServidor;
import br.com.ifba.infrastructure.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 *
 * @author Gusd
 */
@Service
public class ServiceFuncaoServidor implements IServiceFuncaoServidor {

    private final static String FUNCAO_NULL = "A função do técnico está vazia, preencha e tente novamente.";
    private final static String FUNCAO_NAO_EXISTE = "A função informada não existe.";
    private final static String FUNCAO_DELETADA = "Função deletada com sucesso.";
    private final static String CAMPO_VAZIO = "Há campo vazio, preencha e tente novamente.";

    @Autowired
    private IDaoFuncaoServidor daoFuncaoServidor;

    @Override
    public FuncaoServidor saveFuncaoServidor(FuncaoServidor funcaoServidor) {
        if (funcaoServidor == null) {
            throw new BusinessException(FUNCAO_NULL);
        }
        
        return daoFuncaoServidor.save(funcaoServidor);
    }

    @Override
    public String deleteFuncaoServidor(Long id) {
        if (daoFuncaoServidor.existsById(id) == false) {
            throw new BusinessException(FUNCAO_NAO_EXISTE);
        }
        daoFuncaoServidor.delete(daoFuncaoServidor.getReferenceById(id));
        return FUNCAO_DELETADA;
    }

    @Override
    public List<FuncaoServidor> getAllFuncaoServidor() {
        return daoFuncaoServidor.findAll();
    }

}