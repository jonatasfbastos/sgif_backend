package br.com.ifba.relatoriomensal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.relatoriomensal.dao.IDaoRelatorioMensal;
import br.com.ifba.relatoriomensal.model.RelatorioMensal;

@Service
public class ServiceRelatorioMensal implements IServiceRelatorioMensal{

    @Autowired
    private IDaoRelatorioMensal daoRelatorio;

    // mensagem de erro se o Pessoa for null;
    public final static String Relatorio_NULL = "Relatório null";

    // mensagem de erro se o Pessoa já existir;
    public final static String Relatorio_EXISTE = "O Relatório já existe,";

    // mensagem de erro se o Pessoa não existir no banco;
    public final static String Relatorio_NAO_EXISTE = "O Relatorio não existe na base de dados";

    // mensagem de erro se o Pessoa for inválido;
    public final static String Relatorio_INVALIDO = "Relatório inválido";

    @Override
    public RelatorioMensal saveRelatorioMensal(RelatorioMensal relatorio) {
        return daoRelatorio.save(relatorio);
    }

    @Override
    public List<RelatorioMensal> getAllRelatorioMensal() {
        return (List<RelatorioMensal>) this.daoRelatorio.findAll();

    }

    @Override
    public void delete(RelatorioMensal relatorio) {
        if (relatorio == null) {
            throw new BusinessException(Relatorio_NULL);
        } else {
            this.daoRelatorio.delete(relatorio);
            return;
        }
    }
    
}
