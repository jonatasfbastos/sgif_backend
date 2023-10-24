package br.com.ifba.entity.notificacao.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Esta classe representa uma notificação.
 *
 * @author tarciiz
 * Editado por Andesson Reis
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
    private UUID whatId;

    @Column(nullable = false, updatable = false)
    private String whatObjectName;

    @Column(nullable = false)
    private boolean read = false;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime sendDateTime;
}
