package br.com.ifba.sgif.api.entity.relatoriomensal.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.relatoriomensal.dao.IDaoRelatorioMensal;
import br.com.ifba.sgif.api.entity.relatoriomensal.dto.RelatorioMensalResponseDto;
import br.com.ifba.sgif.api.entity.relatoriomensal.model.RelatorioMensal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.sgif.api.infrastructure.exception.BusinessException;
import br.com.ifba.sgif.api.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;

/**
 * Service que fornece operações relacionadas a Relatórios Mensais.
 *
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
 */
@Service
public class ServiceRelatorioMensal implements IServiceRelatorioMensal {

    // =========================================================== //
    // ======================= [ ATRIBUTOS ] ===================== //
    // =========================================================== //

    @Autowired
    private IDaoRelatorioMensal relatorioMensalDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // ========================= [ MÉTODOS ] ===================== //
    // =========================================================== //

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Salva um Relatório Mensal na base de dados e retorna um objeto DTO com os dados resumidos do Relatório Mensal salvo.
     *
     * @param relatorio - O Relatório Mensal que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do Relatório Mensal salvo.
     */
    @Override
    public RelatorioMensalResponseDto saveRelatorioMensal(RelatorioMensal relatorio) {

        return objectMapperUtil.map(
                relatorioMensalDao.save(relatorio),
                RelatorioMensalResponseDto.class);
    }

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Obtém uma lista de todos os Relatórios Mensais como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os Relatórios Mensais.
     */
    @Override
    public List<RelatorioMensalResponseDto> getAllRelatorioMensal() {

        return objectMapperUtil.mapAll(
                this.relatorioMensalDao.findAll(),
                RelatorioMensalResponseDto.class);
    }

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Deleta um Relatório Mensal com base no ID.
     *
     * @param id - O ID do Relatório Mensal a ser deletado.
     * @return um objeto DTO com os dados do Relatório Mensal deletado.
     */
    @Override
    public RelatorioMensalResponseDto delete(UUID id) {

        return this.relatorioMensalDao.findById(id)
                .map(relatorioMensal -> {
                    relatorioMensalDao.delete(relatorioMensal);
                    return objectMapperUtil.map(relatorioMensal, RelatorioMensalResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }
}
