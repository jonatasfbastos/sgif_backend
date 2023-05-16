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
    public final static String FUNCAO_NAO_EXISTE = "A função informada não existe.";
    public final static String FUNCAO_INVÁLIDA = "Função inválida.";
    public final static String FUNCAO_EXISTE = "Função já existe";

    @Autowired
    private IDaoFuncaoServidor daoFuncaoServidor;

    @Override
    public FuncaoServidor saveFuncaoServidor(FuncaoServidor funcaoServidor) {
        if (funcaoServidor == null) {
            throw new BusinessException(FUNCAO_NULL);
        } else{
            return daoFuncaoServidor.save(funcaoServidor);
        }      
    }

    @Override
    public void deleteFuncaoServidor(FuncaoServidor funcaoServidor) {
        if (funcaoServidor == null) {
            throw new BusinessException(FUNCAO_NULL);
        } else{
            this.daoFuncaoServidor.delete(funcaoServidor);
            return;
        }
    }

    @Override
    public List<FuncaoServidor> getAllFuncaoServidor() {
        return daoFuncaoServidor.findAll();
    }

    @Override
    public FuncaoServidor updateFuncaoServidor(FuncaoServidor funcaoServidor) {
        if (funcaoServidor == null) {
            throw new BusinessException(FUNCAO_NULL);
        } else if (daoFuncaoServidor.findById(funcaoServidor.getId()) == null) {
            throw new BusinessException(FUNCAO_EXISTE);
        } else {
            return daoFuncaoServidor.save(funcaoServidor);
        }
    }

}