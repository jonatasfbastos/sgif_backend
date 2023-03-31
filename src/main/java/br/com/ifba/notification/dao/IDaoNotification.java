/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package br.com.ifba.notification.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.notification.model.Notification;

/**
 *
 * @author tarciiz
 */
public interface IDaoNotification extends JpaRepository<Notification, Long> {

    public abstract List<Notification> findByReaded(boolean readed);

    public abstract Optional<Notification> findById(Long id);

    public abstract Notification findByWhatIdAndWhatObjectName(Long whatId, String whatObjectName);
}