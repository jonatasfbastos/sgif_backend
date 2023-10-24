package br.com.ifba.entity.notificacao.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.entity.notificacao.dao.IDaoNotification;
import br.com.ifba.entity.notificacao.dto.NotificacaoResponseDto;
import br.com.ifba.entity.notificacao.model.Notificacao;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * Service que fornece operações relacionadas a Notificação.
 *
 * @author tarciiz
 * @since V1.0.1
 * Editado por Andesson Reis
 */
@Service
public class ServiceNotificacao implements IServiceNotificacao {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoNotification notificacaoDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    /**
     * Salva uma Notificação na base de dados e retorna um objeto DTO com os dados resumidos da Notificação salva.
     *
     * @param notificacao - A Notificação que será salva na base de dados.
     * @return um objeto DTO com os dados resumidos da Notificação salva.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public NotificacaoResponseDto saveNotification(Notificacao notificacao) {
    
        return objectMapperUtil.map(
                notificacaoDao.save(notificacao),
                NotificacaoResponseDto.class);
    }

    /**
     * Atualiza uma Notificação na base de dados e retorna um objeto DTO com os dados resumidos da Notificação atualizada.
     *
     * @param notificacao - A Notificação que será atualizada na base de dados.
     * @return um objeto DTO com os dados resumidos da Notificação atualizada.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public NotificacaoResponseDto updateNotification(Notificacao notificacao) {
        notificacaoDao.findById(notificacao.getId())
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        return objectMapperUtil.map(
                notificacaoDao.save(notificacao),
                NotificacaoResponseDto.class);
    }

    /**
     * Deleta uma Notificação com base no objeto Notificação.
     *
     * @param id - O objeto Notificação a ser deletado.
     * @return um objeto DTO com os dados da Notificação deletada.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public NotificacaoResponseDto deleteNotification(UUID id) {

        return this.notificacaoDao.findById(id)
                .map(notificacao -> {
                    notificacaoDao.delete(notificacao);
                    return objectMapperUtil.map(notificacao, NotificacaoResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }
    
    /**
     * Obtém uma lista de todas as Notificações como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as Notificações.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public List<NotificacaoResponseDto> getAllNotification() {
        return objectMapperUtil.mapAll(
                this.notificacaoDao.findAll(),
                NotificacaoResponseDto.class);
    }
}
