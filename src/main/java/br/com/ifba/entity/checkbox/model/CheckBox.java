/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.entity.checkbox.model;

import br.com.ifba.entity.multiplaescolha.model.MultiplaEscolha;
import br.com.ifba.entity.opcao.model.Opcao;
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
@Table(name = "check_box")
@Data
@EqualsAndHashCode(callSuper = false)
public class CheckBox extends MultiplaEscolha{
    @OneToMany(mappedBy = "checkBox", fetch = FetchType.LAZY)
    private List<Opcao> opcoesSelecionadas;
}
