
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.notification.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import lombok.Data;

/**
 *
 * @author tarciiz
 */

@Entity
@Table(name = "notification")
@Data
public class Notification extends PersistenceEntity {

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String body;

    @Column(nullable = false, updatable = false)
    Long whatId;

    @Column(nullable = false, updatable = false)
    String whatObjectName;

    @Column(nullable = false)
    boolean readed = false;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    LocalDateTime sendDateTime;

    public Notification() {
    }

    public Notification(String title, String body, PersistenceEntity entity) {
        this.buildNotification(title, body, entity);
    }

    public void buildNotification(String title, String body, PersistenceEntity entity) {
        this.title = title;
        this.body = body;
        this.whatId = entity.getId();
        this.whatObjectName = entity.getClass().getSimpleName();
    }

    public static Notification createNotification(String title, String body, PersistenceEntity entity) {
        Notification not = new Notification();
        not.title = title;
        not.body = body;
        not.whatId = entity.getId();
        not.whatObjectName = entity.getClass().getSimpleName();
        return not;
    }
}