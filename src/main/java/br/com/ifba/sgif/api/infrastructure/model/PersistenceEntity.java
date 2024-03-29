package br.com.ifba.sgif.api.infrastructure.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

/**
 * @author rocki.julius
 * Editado por Giovane Neves
 * Desde V1.0.1
 */
@Data
@MappedSuperclass
public class PersistenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
