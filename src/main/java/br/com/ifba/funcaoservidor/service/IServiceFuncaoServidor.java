package br.com.ifba.funcaoservidor.service;

import br.com.ifba.funcaoservidor.model.FuncaoServidor;
import java.util.List;

public interface IServiceFuncaoServidor {

    FuncaoServidor saveFuncaoServidor(FuncaoServidor funcaoservidor);
    String deleteFuncaoServidor(Long id);
    List<FuncaoServidor> getAllFuncaoServidor();

}