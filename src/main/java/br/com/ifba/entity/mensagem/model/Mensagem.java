/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.entity.mensagem.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author felipe
 */

@Entity
@Table(name = "mensagem")
@Data
public class Mensagem extends PersistenceEntity implements Serializable{
    private String nome;
    private String descricao;
    
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    
    @Temporal(TemporalType.DATE)
    private Date dataFim;

}
