/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.notification.service;

import java.util.List;

import br.com.ifba.notification.model.Notification;

/**
 *
 * @author tarciiz
 */
public interface IServiceNotification {
    public abstract Notification saveNotification(Notification notification);

    public abstract Notification updateNotification(Notification notification);

    public abstract void deleteNotification(Notification notification);

    public abstract List<Notification> getAllNotification();

    public abstract List<Notification> findByReaded(boolean readed);

    public abstract Notification findById(Long id);

    public abstract Notification findByWhatIdAndWhatObjectName(Long whatId, String whatObjectName);

}
