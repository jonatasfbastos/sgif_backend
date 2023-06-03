package br.com.ifba.avaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.avaliacao.dao.IDaoAvaliacao;
import br.com.ifba.avaliacao.model.Avaliacao;
import br.com.ifba.infrastructure.exception.BusinessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ServiceAvaliacao implements IServiceAvaliacao {

    //================= CONSTANTES =============================================
    // Mensagem de erro se Avaliacao for null.
    public final static String AVALIACAO_NULL = "Dados da Avaliacao nao preenchidos";

    // Mensagem de erro se  Avaliacao já existe.
    public final static String AVALIACAO_EXISTE = "Avaliacao ja existente no Banco de dados";

    // Mensagem de erro se Avaliacao não existir no banco.
    public final static String AVALIACAO_NAO_EXISTE = "Avaliacao nao existente no Banco de dados";

    // Mensagem de erro se Avaliacao for inválida.
    public final static String AVALIACAO_INVALIDO = "As informacoes da Avaliacao nao sao validas";
    
    // Mensagem de erro em caso de dados null para filtrar Avaliacao.
    public final static String DADOS_NULL = "Dados invalidos para filtrar";
    
    // Mensagem de erro em caso de período inválido para filtrar Avaliacao.
    public final static String PERIODO_INVALIDO = "Periodo invalido para filtrar";

    //================= OBJETO =================================================
    @Autowired
    private IDaoAvaliacao avaliacaoDao;

    //================= MÉTODOS ================================================
    @Override
    public Avaliacao saveAvaliacao(Avaliacao avaliacao) {
        if (avaliacao == null) {
            throw new BusinessException(AVALIACAO_NULL);
        }

        return avaliacaoDao.save(avaliacao);
    }

    @Override
    public Avaliacao updateAvaliacao(Avaliacao avaliacao) {
        if (avaliacao == null) {
            throw new BusinessException(AVALIACAO_NULL);
        }
        if (avaliacaoDao.existsById(avaliacao.getId()) == false) {
            throw new BusinessException(AVALIACAO_NAO_EXISTE);
        }
        return avaliacaoDao.save(avaliacao);
    }

    @Override
    public void deleteAvaliacao(Avaliacao avaliacao) {
        if (avaliacao == null) {
            throw new BusinessException(AVALIACAO_NULL);
        }
        if (avaliacaoDao.existsById(avaliacao.getId()) == false) {
            throw new BusinessException(AVALIACAO_NAO_EXISTE);
        }
        avaliacaoDao.delete(avaliacao);
    }

    @Override
    public List<Avaliacao> getAllAvaliacao() {
        return this.avaliacaoDao.findAll();
    }

    @Override
    public Avaliacao findById(Long id) {
        return avaliacaoDao.getReferenceById(id);
    }
    
    @Override
    public List<Avaliacao> filtrarAvaliacao(String dtInicio, String dtFim, Long idDisciplina) {
        // Verificações se dados são null.
        if (dtInicio == null || dtFim == null || idDisciplina == null) {
            throw new BusinessException(DADOS_NULL);
        }
        // =================== Utilizados para pesquisa. =======================
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date inicio = new Date();
        Date fim = new Date();
        List<Avaliacao> avaliacoes = avaliacaoDao.findAll();
        List<Avaliacao> filtro = new ArrayList<Avaliacao>();
        Date comparaInicio;
        Date comparaFim;
        // Transfomação das strings em datas e verificação do período desejado.
        try {
            inicio = formatter.parse(dtInicio);
            fim = formatter.parse(dtFim);
            if (fim.before(inicio)) {
                throw new BusinessException(PERIODO_INVALIDO);
            }
        } catch (ParseException ex) {
            Logger.getLogger(ServiceAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Verificação se todas as disciplinas devem ser incluídas.
        if (idDisciplina == 0) {
            for (Avaliacao avl : avaliacoes) {
                try {
                    comparaInicio = formatter.parse(avl.getDataInicio());
                    comparaFim = formatter.parse(avl.getDataFim());
                    if (inicio.before(comparaInicio)
                            && fim.after(comparaFim)) {
                        filtro.add(avl);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(ServiceAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return filtro;
        }
        // Pesquisa por disciplina específica nos filtros selecionados.
        for (Avaliacao avl : avaliacoes) {
            try {
                comparaInicio = formatter.parse(avl.getDataInicio());
                comparaFim = formatter.parse(avl.getDataFim());
                if (inicio.before(comparaInicio)
                        && fim.after(comparaFim)
                        && avl.getDisciplina().getId() == idDisciplina) {
                    filtro.add(avl);
                }
            } catch (ParseException ex) {
                Logger.getLogger(ServiceAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return filtro;
    }
}
