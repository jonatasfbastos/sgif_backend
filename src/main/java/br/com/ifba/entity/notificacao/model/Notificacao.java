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
 * Editado por Andesson Reis, Giovane Neves
 * @since V1.0.1
 * 
 * Esta classe representa uma notificação da aplicação.
 * Nenhum dos atributos desta classe pode ser nulo.
 */
@Entity(name = "notificao")
@Table(name = "notificacoes")
public class Notificacao extends PersistenceEntity {

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "corpo", nullable = false)
    private String corpo;

    @Column(name = "qual_id", nullable = false, updatable = false)
    private UUID qualId;

    @Column(name = "qual_nome_objeto", nullable = false, updatable = false)
    private String qualNomeObjeto;

    @Column(name = "lido", nullable = false)
    private boolean lido;

    @Column(name = "data_envio", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime dataEnvio;

}
