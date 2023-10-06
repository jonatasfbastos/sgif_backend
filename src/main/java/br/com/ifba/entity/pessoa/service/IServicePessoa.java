/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.entity.pessoa.service;

import java.util.List;

import br.com.ifba.entity.pessoa.model.Pessoa;
import org.springframework.stereotype.Service;

/**
 *
 * @author matheus lima
 */
@Service
public interface IServicePessoa {

    public abstract Pessoa savePessoa(Pessoa pessoa);

    public abstract void delete(Pessoa pessoa);

    public abstract List<Pessoa> getAllPessoas();

    public List<Pessoa> findByNome(String name);

    public Pessoa findById(Long id);

    // public Pessoa findByLoginOrEmailAndSenha(String login, String email, String
    // senha);

}
