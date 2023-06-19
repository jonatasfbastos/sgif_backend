package br.com.ifba.avaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.avaliacao.dao.IDaoAvaliacao;
import br.com.ifba.avaliacao.model.Avaliacao;
import br.com.ifba.infrastructure.exception.BusinessException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Objects;

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
        // Transformação das strings em LocalDate para verificação.
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                .withResolverStyle(ResolverStyle.STRICT);
        LocalDate dataInicio = LocalDate.parse(avaliacao.getDataInicio(), parser);
        LocalDate dataFim = LocalDate.parse(avaliacao.getDataFim(), parser);
        // Verificação se a data final é antes da data inicial (não permitido).
        if (dataFim.isBefore(dataInicio)) {
            throw new BusinessException(AVALIACAO_INVALIDO);
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
        // Transformação das strings em LocalDate para verificação.
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                .withResolverStyle(ResolverStyle.STRICT);
        LocalDate dataInicio = LocalDate.parse(avaliacao.getDataInicio(), parser);
        LocalDate dataFim = LocalDate.parse(avaliacao.getDataFim(), parser);
        // Verificação se a data final é antes da data inicial (não permitido).
        if (dataFim.isBefore(dataInicio)) {
            throw new BusinessException(AVALIACAO_INVALIDO);
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
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                .withResolverStyle(ResolverStyle.STRICT);
        LocalDate inicio;
        LocalDate fim;
        List<Avaliacao> avaliacoes = avaliacaoDao.findAll();
        List<Avaliacao> filtro = new ArrayList<>();
        LocalDate comparaInicio;
        LocalDate comparaFim;
        // Transfomação das strings em datas e verificação do período desejado.
        inicio = LocalDate.parse(dtInicio, parser);
        fim = LocalDate.parse(dtFim, parser);
        if (fim.isBefore(inicio)) {
            throw new BusinessException(PERIODO_INVALIDO);
        }
        inicio = inicio.plusDays(-1);
        fim = fim.plusDays(1);
        // Verificação se todas as disciplinas devem ser incluídas.
        if (idDisciplina == 0) {
            for (Avaliacao avl : avaliacoes) {
                comparaInicio = LocalDate.parse(avl.getDataInicio(), parser);
                comparaFim = LocalDate.parse(avl.getDataFim(), parser);
                if (inicio.isBefore(comparaInicio)
                        && fim.isAfter(comparaFim)) {
                    filtro.add(avl);
                }
            }
            return filtro;
        }
        // Pesquisa por disciplina específica nos filtros selecionados.
        for (Avaliacao avl : avaliacoes) {
            comparaInicio = LocalDate.parse(avl.getDataInicio(), parser);
            comparaFim = LocalDate.parse(avl.getDataFim(), parser);
            if (Objects.equals(avl.getDisciplina().getId(), idDisciplina)
                    && inicio.isBefore(comparaInicio)) {
                if (fim.isAfter(comparaFim)) {
                    filtro.add(avl);
                }
            }
        }
        return filtro;
    }
}
