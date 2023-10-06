package br.com.ifba.entity.relatoriomensal.service;

import java.util.List;

import br.com.ifba.entity.relatoriomensal.model.RelatorioMensal;
import org.springframework.stereotype.Service;

@Service
public interface IServiceRelatorioMensal {

    public abstract RelatorioMensal saveRelatorioMensal(RelatorioMensal relatorio);

    public abstract List<RelatorioMensal> getAllRelatorioMensal();

    public abstract void delete(RelatorioMensal relatorio);

}
