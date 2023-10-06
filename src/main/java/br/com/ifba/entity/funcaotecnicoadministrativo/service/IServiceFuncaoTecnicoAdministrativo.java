package br.com.ifba.entity.funcaotecnicoadministrativo.service;

import br.com.ifba.entity.funcaotecnicoadministrativo.model.FuncaoTecnicoAdministrativo;
import java.util.List;

public interface IServiceFuncaoTecnicoAdministrativo {

    FuncaoTecnicoAdministrativo saveFuncaoTecnicoAdm(FuncaoTecnicoAdministrativo funcaoTecnicoAdm);
    String deleteFuncaoTecnicoAdm(Long id);
    List<FuncaoTecnicoAdministrativo> getAllFuncoesTecnicoAdm();

}