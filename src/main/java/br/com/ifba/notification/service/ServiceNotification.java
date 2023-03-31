/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.notification.dao.IDaoNotification;
import br.com.ifba.notification.model.Notification;

/**
 *
 * @author tarciiz
 */
@Service
public class ServiceNotification implements IServiceNotification {

    // Constantes para condições de erro

    // Notification Null
    public final static String notification_NULL = "Notificação null";

    // Notification exists
    public final static String notification_EXIST = "Notificação já existe";

    // Notification don't exists
    public final static String notification_DONT_EXIST = "A notificação já existe na base de dados";

    // Notification invalid
    public final static String notification_INVALID = "Notificação inválida";

    @Autowired
    private IDaoNotification daoNotification;

    @Override
    public Notification saveNotification(Notification notification) {
        if (notification == null) {
            throw new BusinessException(notification_NULL);
        } else {
            return daoNotification.save(notification);
        }
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
