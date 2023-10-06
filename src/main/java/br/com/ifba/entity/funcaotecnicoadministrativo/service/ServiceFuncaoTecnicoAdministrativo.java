package br.com.ifba.entity.funcaotecnicoadministrativo.service;

import br.com.ifba.entity.funcaotecnicoadministrativo.dao.IDaoFuncaoTecnicoAdministrativo;
import br.com.ifba.entity.funcaotecnicoadministrativo.model.FuncaoTecnicoAdministrativo;
import br.com.ifba.infrastructure.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceFuncaoTecnicoAdministrativo implements IServiceFuncaoTecnicoAdministrativo {

    private final static String FUNCAO_NULL = "A função do técnico está vazia, preencha e tente novamente.";
    private final static String FUNCAO_NAO_EXISTE = "A função informada não existe.";
    private final static String FUNCAO_DELETADA = "Função deletada com sucesso.";
    private final static String CAMPO_VAZIO = "Há campo vazio, preencha e tente novamente.";

    @Autowired
    private IDaoFuncaoTecnicoAdministrativo daoFuncaoTecnicoAdministrativo;

    @Override
    public FuncaoTecnicoAdministrativo saveFuncaoTecnicoAdm(FuncaoTecnicoAdministrativo funcaoTecnicoAdm) {
        if (funcaoTecnicoAdm == null) {
            throw new BusinessException(FUNCAO_NULL);
        }
        if (funcaoTecnicoAdm.getNome().isEmpty() || funcaoTecnicoAdm.getDescricao().isEmpty()) {
            throw new BusinessException(CAMPO_VAZIO);
        }
        return daoFuncaoTecnicoAdministrativo.save(funcaoTecnicoAdm);
    }

    @Override
    public String deleteFuncaoTecnicoAdm(Long id) {
        if (daoFuncaoTecnicoAdministrativo.existsById(id) == false) {
            throw new BusinessException(FUNCAO_NAO_EXISTE);
        }
        daoFuncaoTecnicoAdministrativo
                .delete(daoFuncaoTecnicoAdministrativo.getReferenceById(id));
        return FUNCAO_DELETADA;
    }

    @Override
    public List<FuncaoTecnicoAdministrativo> getAllFuncoesTecnicoAdm() {
        return daoFuncaoTecnicoAdministrativo.findAll();
    }

}