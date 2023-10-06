package br.com.ifba.entity.funcaoservidor.service;

import br.com.ifba.entity.funcaoservidor.dao.IDaoFuncaoServidor;
import br.com.ifba.entity.funcaoservidor.model.FuncaoServidor;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.entity.tecnicoadministrativo.dao.IDaoTecnicoAdministrativo;
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
    //mensagem de erro caso exista técnico administrativo atrelado a uma função
    private final static String TECNICO_EXISTE = "Função não pode ser excluída, pois existe Técnico cadastrado";

    @Autowired
    private IDaoFuncaoServidor daoFuncaoServidor;
    private IDaoTecnicoAdministrativo daoTecnicoAdministrativo;

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
        if(funcaoServidor == null) {
            throw new BusinessException(FUNCAO_NULL);
        } 
        if(daoFuncaoServidor.existsById(funcaoServidor.getId()) == false) {
            throw new BusinessException(FUNCAO_NAO_EXISTE);
        }
        if(daoFuncaoServidor.getReferenceById(funcaoServidor.getId()).getTecnicoAdministrativos().isEmpty() == false){
            throw new BusinessException(TECNICO_EXISTE);
        }
        daoFuncaoServidor.delete(funcaoServidor);
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