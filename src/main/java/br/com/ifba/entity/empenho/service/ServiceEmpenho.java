package br.com.ifba.entity.empenho.service;

import br.com.ifba.entity.empenho.dao.IDaoEmpenho;
import br.com.ifba.entity.empenho.dto.EmpenhoResponseDto;
import br.com.ifba.entity.empenho.model.Empenho;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * Interface para serviços relacionados à entidade Empenho.
 *
 * @author rocki.julius
 * @Editado por Andesson Reis
 * @since V1.0.1
 * 
 *        Veja também: {@link br.com.ifba.entity.empenho.model.Empenho}
 */
@Service
public class ServiceEmpenho implements IServiceEmpenho {

    // =========================================================== //
    // =============== [ ATRIBUTOS ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoEmpenho daoEmpenho;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ MÉTODOS ] ================== //
    // =========================================================== //

    /**
     * Salva um empenho (Response DTO) na base de dados.
     *
     * @param empenho O empenho (Response DTO) a ser salvo.
     * @return O empenho (Response DTO) salvo.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public EmpenhoResponseDto saveEmpenho(Empenho empenho) {
        return objectMapperUtil.map(
                daoEmpenho.save(empenho),
                EmpenhoResponseDto.class);
    }




    @Override
    public void deleteEmpenho(Empenho empenho) {
        if (empenho == null) {
            throw new BusinessException(empenho_NULL);
        } else {
            this.daoEmpenho.delete(empenho);
            return;
        }
    }

    @Override
    public List<Empenho> getAllEmpenho() {
        return daoEmpenho.findAll();
    }

}
