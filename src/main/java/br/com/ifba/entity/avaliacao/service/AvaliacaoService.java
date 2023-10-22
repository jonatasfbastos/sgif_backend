package br.com.ifba.entity.avaliacao.service;

import br.com.ifba.entity.avaliacao.dao.IAvaliacaoDao;
import br.com.ifba.entity.avaliacao.dto.AvaliacaoResponseDto;
import br.com.ifba.entity.avaliacao.model.Avaliacao;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.infrastructure.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @author Unknown
 * Editado por Giovane Neves
 * @since Desde V1.0.1
 */
@Service
public class AvaliacaoService implements IAvaliacaoService {

    // =========================================================== //
    // =============== [       ATRIBUTOS        ] ================ //
    // =========================================================== //

    @Autowired
    private IAvaliacaoDao avaliacaoDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;


    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    /**
     * Lista todas as avaliações cadastradas na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return uma lista com todas as turmas da base de dados, ou nulo, caso não exista nenhuma.
     */
    @Override
    public List<AvaliacaoResponseDto> listarAvaliacoes() {

        return this.objectMapperUtil.mapAll(
                this.avaliacaoDao.findAll(),
                AvaliacaoResponseDto.class
        );

    }

    /**
     * Busca uma avaliacao na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da avaliação a ser buscada.
     * @return a avaliação atrelada ao ID passado por parâmetro.
     */
    @Override
    public AvaliacaoResponseDto encontrarAvaliacaoPorId(UUID id) {

        return avaliacaoDao.findById(id)
                .map(av -> this.objectMapperUtil.map(av, AvaliacaoResponseDto.class))
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );

    }

    /**
     * Salva uma avaliação na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param avaliacao A avaliação a ser salva na base de dados.
     * @return DTO com dados da avaliação salva.
     */
    @Override
    public AvaliacaoResponseDto salvarAvaliacao(Avaliacao avaliacao) {

        return Optional.of(avaliacao)
                .filter(av -> this.validarDataFim(av.getDataInicio(), av.getDataFim()))
                .map(av -> this.objectMapperUtil.map(this.avaliacaoDao.save(av), AvaliacaoResponseDto.class))
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.INVALID_DATE.getMensagem())
                );

    }

    /**
     * Atualiza uma avaliação existente na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param avaliacao A avaliação a ser atualizada.
     * @return DTO com dados da avaliação atualizada.
     */
    @Override
    public AvaliacaoResponseDto atualizarAvaliacao(Avaliacao avaliacao) {


        return this.avaliacaoDao.findById(avaliacao.getId())
                .filter(av -> this.avaliacaoDao.existsById(av.getId()))
                .map(av -> Optional.of(av)
                        .filter(a -> this.validarDataFim(a.getDataInicio(), a.getDataFim()))
                        .map(a -> this.objectMapperUtil.map(this.avaliacaoDao.save(a), AvaliacaoResponseDto.class))
                        .orElseThrow(
                                () -> new BusinessException(BusinessExceptionMessage.INVALID_DATE.getMensagem())
                        ))
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );


    }

    /**
     * Deleta uma avaliação na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da avaliação a ser deletada.
     * @return DTO om dados da avaliação deletada.
     */
    @Override
    public AvaliacaoResponseDto deletarAvaliacaoPorId(UUID id) {

        return this.avaliacaoDao.findById(id)
                .map(av -> {
                    this.avaliacaoDao.delete(av);
                    return this.objectMapperUtil.map(av, AvaliacaoResponseDto.class);
                })
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );

    }

    /**
     * Valida a data de fim da avaliação.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param dataInicio A data de inicio da avaliacao.
     * @param dataFim A data de fim da avaliacao.
     * @return 'true' caso a data de fim seja válida, 'false' caso contrário.
     */
    private boolean validarDataFim(String dataInicio, String dataFim) {

        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                .withResolverStyle(ResolverStyle.STRICT);

        Stream.of(dataInicio, dataFim)
                .map(dataStr -> LocalDate.parse(dataStr, parser))
                .reduce((dInicio, dFim) -> dFim.isBefore(dInicio) ? dFim : dInicio)
                .map(dataMenor -> false);

        return true;

    }


    // Temporariamente desabilitado
    /*
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
    */

}
