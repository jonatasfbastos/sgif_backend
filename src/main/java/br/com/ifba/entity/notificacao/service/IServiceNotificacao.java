package br.com.ifba.entity.notificacao.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.entity.notificacao.dto.NotificacaoResponseDto;
import br.com.ifba.entity.notificacao.model.Notificacao;

/**
 * Interface de serviço para Notificação.
 *
 * @author tarciiz
 * @since V1.0.1
 * Editado por Andesson Reis
 */
public interface IServiceNotificacao {

    /**
     * Salva uma Notificação na base de dados e retorna um objeto DTO com os dados resumidos da Notificação salva.
     *
     * @param notificacao - A Notificação que será salva na base de dados.
     * @return um objeto DTO com os dados resumidos da Notificação salva.
     */
    NotificacaoResponseDto saveNotification(Notificacao notificacao);

    /**
     * Atualiza uma Notificação na base de dados e retorna um objeto DTO com os dados resumidos da Notificação atualizada.
     *
     * @param notificacao - A Notificação que será atualizada na base de dados.
     * @return um objeto DTO com os dados resumidos da Notificação atualizada.
     */
    NotificacaoResponseDto updateNotification(Notificacao notificacao);

    /**
     * Deleta uma Notificação com base no objeto Notificação.
     *
     * @param id - O objeto Notificação a ser deletado.
     * @return um objeto DTO com os dados da Notificação deletada.
     */
    NotificacaoResponseDto deleteNotification(UUID id);

    /**
     * Obtém uma lista de todas as Notificações como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as Notificações.
     */
    List<NotificacaoResponseDto> getAllNotification();

    /**
     * Obtém uma lista de Notificações com base na leitura (readed) informada.
     *
     * @param readed - O valor booleano que indica se a notificação foi lida ou não.
     * @return uma lista de objetos DTO representando as Notificações com a leitura especificada.
     */
   // List<NotificacaoResponseDto> findByReaded(boolean readed);

    /**
     * Encontra uma Notificação com base no ID e no nome do objeto associado.
     *
     * @param whatId - O ID do objeto associado.
     * @param whatObjectName - O nome do objeto associado.
     * @return um objeto DTO com os dados da Notificação encontrada.
     */
    //NotificacaoResponseDto findByWhatIdAndWhatObjectName(UUID whatId, String whatObjectName); 
}
