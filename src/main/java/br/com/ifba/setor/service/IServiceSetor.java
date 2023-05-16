/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.setor.service;

import java.util.List;

import br.com.ifba.setor.model.Setor;

/**
 *
 * @author Everton.
 */
public interface IServiceSetor {

    public abstract Setor saveSetor(Setor setor);

    public abstract Setor updateSetor(Setor setor);

    public abstract void deleteSetor(Setor setor);

    public abstract List<Setor> getAllSetor();

}
