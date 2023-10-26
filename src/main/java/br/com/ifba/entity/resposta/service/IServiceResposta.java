/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.entity.resposta.service;

import br.com.ifba.entity.resposta.dto.RespostaResponseDto;
import br.com.ifba.entity.resposta.model.Resposta;
import java.util.List;
import java.util.UUID;

/**
 * @author Ellen Cristina
 * Editado por Giovane Neves
 * @since V1.0.1
 */
public interface IServiceResposta {

    // =========================================================== //
    // =============== [ ASSINATURAS DE MÉTODOS ] ================ //
    // =========================================================== //

    List<RespostaResponseDto> listarRespostas();
    Resposta salvarResposta(final Resposta resposta);

    Resposta atualizarResposta(final Resposta resposta);

    RespostaResponseDto deletarRespostaPorId(final UUID id);

}
