package br.com.ifba.entity.relatoriomensal.service;

import java.util.List;

import br.com.ifba.entity.relatoriomensal.dao.IDaoRelatorioMensal;
import br.com.ifba.entity.relatoriomensal.dto.RelatorioMensalResponseDto;
import br.com.ifba.entity.relatoriomensal.model.RelatorioMensal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

@Service
public class ServiceRelatorioMensal implements IServiceRelatorioMensal{

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
     * Salva um Relatório Mensal na base de dados e retorna um objeto DTO com os dados resumidos do Relatório Mensal salvo.
     *
     * @param relatorio - O Relatório Mensal que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do Relatório Mensal salvo.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public RelatorioMensalResponseDto saveRelatorioMensal(RelatorioMensal relatorio) {

        return objectMapperUtil.map(
                relatorioMensalDao.save(relatorio),
                RelatorioMensalResponseDto.class);
    }

    /**
     * Obtém uma lista de todos os Relatórios Mensais como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os Relatórios Mensais.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public List<RelatorioMensalResponseDto> getAllRelatorioMensal() {
        
        return objectMapperUtil.mapAll(
                this.relatorioMensalDao.findAll(),
                RelatorioMensalResponseDto.class);
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
