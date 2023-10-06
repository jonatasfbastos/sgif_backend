package br.com.ifba.entity.servidor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ifba.entity.servidor.model.Servidor;

@Service
public interface IServiceServidor {

    public abstract Servidor saveServidor(Servidor servidor);

    public abstract Servidor updateTecincoAdministrativo(Servidor servidor);

    public abstract void deleteServidor(Servidor servidor);

    public abstract List<Servidor> getAllServidor();
    
}