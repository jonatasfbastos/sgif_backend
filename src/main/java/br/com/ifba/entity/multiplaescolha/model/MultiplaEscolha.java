/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.entity.multiplaescolha.model;

import br.com.ifba.entity.opcao.model.Opcao;
import br.com.ifba.entity.resposta.model.Resposta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Ellen Cristina
 */
@Entity
@Table(name = "multipla_escolha")
@Data
@EqualsAndHashCode(callSuper = false)
public class MultiplaEscolha extends Resposta{
    @JsonIgnore
    @OneToMany(mappedBy = "multiplaEscolha", fetch = FetchType.EAGER)
    private List<Opcao> opcao;
}
