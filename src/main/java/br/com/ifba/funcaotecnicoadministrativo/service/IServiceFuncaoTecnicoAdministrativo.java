package br.com.ifba.funcaotecnicoadministrativo.service;

import br.com.ifba.funcaotecnicoadministrativo.model.FuncaoTecnicoAdministrativo;
import java.util.List;

public interface IServiceFuncaoTecnicoAdministrativo {

    FuncaoTecnicoAdministrativo saveFuncaoTecnicoAdm(FuncaoTecnicoAdministrativo funcaoTecnicoAdm);
    FuncaoTecnicoAdministrativo updateFuncaoTecnicoAdm(FuncaoTecnicoAdministrativo funcaoTecnicoAdm);
    void deleteFuncaoTecnicoAdm(Long id);
    List<FuncaoTecnicoAdministrativo> getAllFuncoesTecnicoAdm();

}