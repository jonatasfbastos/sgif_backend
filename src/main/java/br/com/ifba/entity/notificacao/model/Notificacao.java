package br.com.ifba.entity.notificacao.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Esta classe representa uma notificação.
 *
 * @author tarciiz
 * @Editado por Andesson Reis
 * @since V1.0.1
 * 
 * Esta classe representa uma notificação da aplicação.
 * Nenhum dos atributos desta classe pode ser nulo.
 */
@Entity
@Table(name = "notificacao")
public class Notificacao extends PersistenceEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false, updatable = false)
    private Long whatId;

    @Column(nullable = false, updatable = false)
    private String whatObjectName;

    @Column(nullable = false)
    private boolean read = false;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime sendDateTime;
/*
    //Todo  Revisar essa criação

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
        Notification notification = new Notification();
        notification.title = title;
        notification.body = body;
        notification.whatId = entity.getId();
        notification.whatObjectName = entity.getClass().getSimpleName();
        return notification;
    }
*/
}
