package br.com.ifba.servidor.service;

import java.util.List;

import br.com.ifba.servidor.model.Servidor;

public interface IServiceServidor {
    public Servidor saveServidor(Servidor servidor);
    public Servidor updateTecincoAdministrativo(Servidor servidor);
    String deleteServidor(Long id);
    //public void deleteServidor(Servidor servidor);
    public List<Servidor> getAllServidor();
    public List<Servidor> findByNome(String nome);
    public Servidor findById(Long id);
}
