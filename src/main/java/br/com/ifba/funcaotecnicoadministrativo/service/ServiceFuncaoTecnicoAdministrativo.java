package br.com.ifba.funcaotecnicoadministrativo.service;

import br.com.ifba.funcaotecnicoadministrativo.dao.IDaoFuncaoTecnicoAdministrativo;
import br.com.ifba.funcaotecnicoadministrativo.model.FuncaoTecnicoAdministrativo;
import br.com.ifba.infrastructure.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceFuncaoTecnicoAdministrativo implements IServiceFuncaoTecnicoAdministrativo {

    private final static String FUNCAO_NULL = "A função está vázia, preencha e tente novamente.";
    private final static String FUNCAO_EXISTE = "A função informada já existe.";
    private final static String FUNCAO_NAO_EXISTE = "A função informada não existe.";

    @Autowired
    private IDaoFuncaoTecnicoAdministrativo daoFuncaoTecnicoAdministrativo;

    @Override
    public FuncaoTecnicoAdministrativo saveFuncaoTecnicoAdm(FuncaoTecnicoAdministrativo funcaoTecnicoAdm) {
        if (funcaoTecnicoAdm == null) {
            throw new BusinessException(FUNCAO_NULL);
        }
        if (daoFuncaoTecnicoAdministrativo.existsByNome(funcaoTecnicoAdm.getNome())) {
            throw new BusinessException(FUNCAO_EXISTE);
        }
        return daoFuncaoTecnicoAdministrativo.save(funcaoTecnicoAdm);
    }

    @Override
    public FuncaoTecnicoAdministrativo updateFuncaoTecnicoAdm(FuncaoTecnicoAdministrativo funcaoTecnicoAdm) {
        if (funcaoTecnicoAdm == null) {
            throw new BusinessException(FUNCAO_NULL);
        }
        return daoFuncaoTecnicoAdministrativo.save(funcaoTecnicoAdm);
    }

    @Override
    public void deleteFuncaoTecnicoAdm(Long id) {
        if (daoFuncaoTecnicoAdministrativo.existsById(id) == false) {
            throw new BusinessException(FUNCAO_NAO_EXISTE);
        }
        daoFuncaoTecnicoAdministrativo
                .delete(daoFuncaoTecnicoAdministrativo.getReferenceById(id));
    }

    @Override
    public List<FuncaoTecnicoAdministrativo> getAllFuncoesTecnicoAdm() {
        return daoFuncaoTecnicoAdministrativo.findAll();
    }

}