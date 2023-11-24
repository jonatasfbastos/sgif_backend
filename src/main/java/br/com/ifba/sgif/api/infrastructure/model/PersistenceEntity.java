package br.com.ifba.sgif.api.infrastructure.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

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
    @GeneratedValue
    private UUID id;
}
