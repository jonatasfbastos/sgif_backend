package br.com.ifba.relatoriomensal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ifba.relatoriomensal.model.RelatorioMensal;

@Service
public interface IServiceRelatorioMensal {

    public abstract RelatorioMensal saveRelatorioMensal(RelatorioMensal relatorio);

    public abstract List<RelatorioMensal> getAllRelatorioMensal();

    public abstract void delete(RelatorioMensal relatorio);

}
