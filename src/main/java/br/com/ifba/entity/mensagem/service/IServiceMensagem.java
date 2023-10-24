package br.com.ifba.entity.mensagem.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.entity.mensagem.dto.MensagemResponseDto;
import br.com.ifba.entity.mensagem.model.Mensagem;

/**
 * Interface de serviço para Mensagem.
 *
 * @author felipe
 * Editado por Andesson Reis
 * @since V1.0.1
 */
public interface IServiceMensagem {

    /**
     * Salva uma Mensagem na base de dados e retorna um objeto DTO com os dados resumidos da Mensagem salva.
     *
     * @param mensagem - A Mensagem que será salva na base de dados.
     * @return um objeto DTO com os dados resumidos da Mensagem salva.
     */
    MensagemResponseDto saveMensagem(Mensagem mensagem);

    /**
     * Atualiza uma Mensagem na base de dados e retorna um objeto DTO com os dados resumidos da Mensagem atualizada.
     *
     * @param mensagem - A Mensagem que será atualizada na base de dados.
     * @return um objeto DTO com os dados resumidos da Mensagem atualizada.
     */
    MensagemResponseDto updateMensagem(Mensagem mensagem);

    /**
     * Deleta uma Mensagem com base no ID.
     *
     * @param id - O ID da Mensagem a ser deletada.
     * @return um objeto DTO com os dados da Mensagem deletada.
     */
    MensagemResponseDto deleteMensagem(UUID id);

    /**
     * Obtém uma lista de todas as Mensagens como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as Mensagens.
     */
    List<MensagemResponseDto> getAllMensagem();
}
