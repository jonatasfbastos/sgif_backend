package br.com.ifba.entity.requisicao.service;

import java.util.List;

import br.com.ifba.entity.requisicao.dao.IDaoRequisicao;
import br.com.ifba.entity.requisicao.dto.RequisicaoResponseDto;
import br.com.ifba.entity.requisicao.model.Requisicao;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vitor 
 * @Editado por Andesson Reis
 * Desde V1.0.1
 */
@Service
public class ServiceRequisicao implements IServiceRequisicao {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoRequisicao daoRequisicao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== /


    /**
     * @author Andesson Reis
     * Desde V1.0.1

     * Salva uma permissão na base de dados e retorna um objeto DTO com os dados da permissão salva.
     *
     * @param requisicao - A permissão que será salva na base de dados.
     * @return um objeto DTO com os dados da permissão salva.
     */
    @Override
    public RequisicaoResponseDto saveRequisicao(Requisicao requisicao) {
        return objectMapperUtil.map(
                daoRequisicao.save(requisicao),
                RequisicaoResponseDto.class);
    }

    @Override
    public Requisicao updateRequisicao(Requisicao requisicao) {
        if (requisicao == null) {
            throw new BusinessException(REQUISICAO_NULL);
        } else if (daoRequisicao.findById(requisicao.getId()) == null) {
            throw new BusinessException(REQUISICAO_NAO_EXISTE);
        } else {
            return daoRequisicao.save(requisicao);
        }
    }

    @Override
    public void deleteRequisicao(Requisicao requisicao) {
        if (requisicao == null) {
            throw new BusinessException(REQUISICAO_NULL);
        } else {
            this.daoRequisicao.delete(requisicao);
            return;
        }

    }

    @Override
    public List<Requisicao> getAllRequisicao() {
        return this.daoRequisicao.findAll();
    }

}
