/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.checkbox.service;

import br.com.ifba.checkbox.model.CheckBox;
import java.util.List;

/**
 *
 * @author Ellen Cristina
 */
public interface IServiceCheckBox {
    // Salva CheckBox.
    public CheckBox saveCheckBox(CheckBox checkbox);
    // Atualiza CheckBox.
    public CheckBox updateCheckBox(CheckBox checkbox);
    // Deleta CheckBox.
    public void deleteCheckBox(CheckBox checkbox);
     // Metodo que retorna todos os CheckBox da base de dados.
    public List<CheckBox> getAllCheckBox();
}
