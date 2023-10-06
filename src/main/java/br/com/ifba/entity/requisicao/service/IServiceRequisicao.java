/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.entity.requisicao.service;

import java.util.List;

import br.com.ifba.entity.requisicao.model.Requisicao;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vitor
 */
@Service
public interface IServiceRequisicao {
    public abstract Requisicao saveRequisicao(Requisicao requisicao);

    public abstract Requisicao updateRequisicao(Requisicao requisicao);

    public abstract void deleteRequisicao(Requisicao requisicao);

    public abstract List<Requisicao> getAllRequisicao();
}
