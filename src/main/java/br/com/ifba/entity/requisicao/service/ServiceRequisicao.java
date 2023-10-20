package br.com.ifba.entity.requisicao.service;

import java.util.List;
import java.util.Optional;

import br.com.ifba.entity.requisicao.dao.IDaoRequisicao;
import br.com.ifba.entity.requisicao.dto.RequisicaoResponseDto;
import br.com.ifba.entity.requisicao.model.Requisicao;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
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
     * @since V1.0.1

     * Salva uma requisição na base de dados e retorna um objeto DTO com os dados da requisição salva.
     *
     * @param requisicao - A requisição que será salva na base de dados.
     * @return um objeto DTO com os dados da requisição salva.
     */
    @Override
    public RequisicaoResponseDto saveRequisicao(Requisicao requisicao) {
        return objectMapperUtil.map(
                daoRequisicao.save(requisicao),
                RequisicaoResponseDto.class);
    }

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Atualiza uma requisição existente na base de dados.
     * @param requisicao - A requisição que será atualizado.
     * @return dados da requisição atualizado.
     */
    @Override
    public RequisicaoResponseDto updateRequisicao(Requisicao requisicao) {

        return Optional.of(requisicao)
                        .filter(req -> this.daoRequisicao.existsById(requisicao.getId()))
                        .map(req -> objectMapperUtil.map(this.daoRequisicao.save(req), RequisicaoResponseDto.class))
                        .orElseThrow(
                                () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                        );

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
