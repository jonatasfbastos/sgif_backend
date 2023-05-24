/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.statusaluno.service;

import br.com.ifba.statusaluno.model.StatusAluno;
import java.util.List;

/**
 *
 * @author Ellen Cristina
 */
public interface IServiceStatusAluno {
    public abstract StatusAluno saveStatus(StatusAluno status);

    public abstract StatusAluno updateStatus(StatusAluno status);

    public abstract void deleteStatus(StatusAluno status);

    public abstract List<StatusAluno> getAllstatus();
}
