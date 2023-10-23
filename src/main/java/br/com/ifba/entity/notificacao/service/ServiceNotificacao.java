
package br.com.ifba.entity.notificacao.service;

import br.com.ifba.entity.notificacao.dao.IDaoNotification;
import br.com.ifba.entity.notificacao.model.Notificacao;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

import java.util.List;
import java.util.Optional;

import javax.management.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Service que fornece operações relacionadas a Notificação.
 *
 * @author tarciiz
 * @since V1.0.1
 * @Editado por Andesson Reis
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



Aqui está o código para o serviço Notificacao com a documentação Javadoc e a mesma regra de negócio:

java
Copy code
package br.com.ifba.entity.notificacao.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.entity.notificacao.dto.NotificacaoResponseDto;
import br.com.ifba.entity.notificacao.model.Notificacao;

/**
 * Service que fornece operações relacionadas a Notificação.
 *
 * @author tarciiz
 * @since V1.0.1
 * @Editado por Andesson Reis
 */
@Service
public class NotificacaoService implements IServiceNotificacao {

    @Autowired
    private IDaoNotification notificacaoDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

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

    @Override
    public Notification updateNotification(Notification notification) {
        if (notification == null) {
            throw new BusinessException(notification_NULL);
        } else if (daoNotification.findById(notification.getId()) == null) {
            throw new BusinessException(notification_EXIST);
        } else {
            return daoNotification.save(notification);
        }
    }

    @Override
    public void deleteNotification(Notification notification) {
        if (notification == null) {
            throw new BusinessException(notification_NULL);
        } else {
            this.daoNotification.delete(notification);
            return;
        }
    }

    @Override
    public List<Notification> getAllNotification() {
        return daoNotification.findAll();
    }

    @Override
    public List<Notification> findByReaded(boolean readed) {
        return daoNotification.findByReaded(readed);
    }

    @Override
    public Notification findById(Long id) {
        Optional<Notification> not = daoNotification.findById(id);
        return not.isPresent() ? not.get() : null;
    }

    @Override
    public Notification findByWhatIdAndWhatObjectName(Long whatId, String whatObjectName) {
        return daoNotification.findByWhatIdAndWhatObjectName(whatId, whatObjectName);
    }
}
