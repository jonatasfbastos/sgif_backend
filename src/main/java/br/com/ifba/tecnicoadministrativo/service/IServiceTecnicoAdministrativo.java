package br.com.ifba.tecnicoadministrativo.service;

import java.util.List;

import br.com.ifba.tecnicoadministrativo.model.TecnicoAdministrativo;

public interface IServiceTecnicoAdministrativo {
    public TecnicoAdministrativo saveTecnicoAdministrativo(TecnicoAdministrativo tecnicoAdministrativo);
    public TecnicoAdministrativo updateTecincoAdministrativo(TecnicoAdministrativo tecnicoAdministrativo);
    String deleteTecnicoAdministrativo(Long id);
    //public void deleteTecnicoAdministrativo(TecnicoAdministrativo tecnicoAdministrativo);
    public List<TecnicoAdministrativo> getAllTecnicoAdministrativo();
    public List<TecnicoAdministrativo> findByNome(String nome);
    public TecnicoAdministrativo findById(Long id);
}
