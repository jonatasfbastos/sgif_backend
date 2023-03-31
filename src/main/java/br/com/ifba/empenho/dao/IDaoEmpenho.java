/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package br.com.ifba.empenho.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.empenho.model.Empenho;

/**
 *
 * @author rocki.julius
 */
public interface IDaoEmpenho extends JpaRepository<Empenho, Long> {
    public abstract List<Empenho> validadeBefore(Date validade);

    public abstract List<Empenho> validadeAfter(Date validade);
}