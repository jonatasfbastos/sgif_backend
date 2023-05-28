/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.mensagem.dao;

import br.com.ifba.mensagem.model.Mensagem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author felip
 */
public interface IDaoMensagem extends JpaRepository<Mensagem, Long>{
     public abstract List<Mensagem> findByNome(String name);
     public boolean existsByNome(String nome);
}
