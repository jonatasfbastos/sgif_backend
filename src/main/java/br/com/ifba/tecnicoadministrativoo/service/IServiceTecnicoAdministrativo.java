package br.com.ifba.tecnicoadministrativoo.service;

import java.util.List;

import br.com.ifba.tecnicoadministrativoo.model.TecnicoAdministrativo;

public interface IServiceTecnicoAdministrativo {
    public TecnicoAdministrativo saveTecnicoAdministrativo(TecnicoAdministrativo tecnicoAdministrativo);
    public TecnicoAdministrativo updateTecincoAdministrativo(TecnicoAdministrativo tecnicoAdministrativo);
    public void deleteTecnicoAdministrativo(TecnicoAdministrativo tecnicoAdministrativo);
    public List<TecnicoAdministrativo> getAllTecnicoAdministrativo();
    public List<TecnicoAdministrativo> findByNome(String nome);
    public TecnicoAdministrativo findById(Long id);
}
