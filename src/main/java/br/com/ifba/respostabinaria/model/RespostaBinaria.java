/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.respostabinaria.model;

import br.com.ifba.resposta.model.Resposta;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Ellen Cristina
 */
@Entity
@Table(name = "resposta_binaria")
@Data
@EqualsAndHashCode(callSuper = false)
public class RespostaBinaria extends Resposta{
    private boolean marcado;
    
}
