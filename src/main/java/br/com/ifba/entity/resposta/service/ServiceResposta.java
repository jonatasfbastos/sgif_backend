/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.entity.resposta.service;

import br.com.ifba.entity.resposta.dto.RespostaResponseDto;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.entity.resposta.dao.IDaoResposta;
import br.com.ifba.entity.resposta.model.Resposta;
import java.util.List;
import java.util.UUID;

import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ellen Cristina
 */
public class ServiceResposta implements IServiceResposta{

    // =========================================================== //
    // =============== [       ATRIBUTOS        ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoResposta _respostaDao;
    @Autowired
    private ObjectMapperUtil _objectMapperUtil;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    @Override
    public Resposta salvarResposta(final Resposta resposta) {
        return null;
    }

    @Override
    public Resposta atualizarResposta(final Resposta resposta) {
        return null;
    }

    @Override
    public RespostaResponseDto deletarRespostaPorId(final UUID id) {
        return null;
    }

    @Override
    public List<RespostaResponseDto> listarRespostas() {
        return null;
    }
    
}
