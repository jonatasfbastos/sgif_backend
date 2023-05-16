package br.com.ifba.funcaoservidor.service;

import br.com.ifba.funcaoservidor.model.FuncaoServidor;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IServiceFuncaoServidor {

    public abstract FuncaoServidor saveFuncaoServidor(FuncaoServidor funcaoServidor);
    public abstract FuncaoServidor updateFuncaoServidor(FuncaoServidor funcaoServidor);
    public abstract void deleteFuncaoServidor(FuncaoServidor funcaoServidor);
    public abstract List<FuncaoServidor> getAllFuncaoServidor();

}