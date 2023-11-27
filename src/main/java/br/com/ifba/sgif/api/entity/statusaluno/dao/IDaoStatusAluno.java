/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.sgif.api.entity.statusaluno.dao;

import br.com.ifba.sgif.api.entity.statusaluno.model.StatusAluno;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ellen Cristina
 */
public interface IDaoStatusAluno extends JpaRepository<StatusAluno, Long> {
        /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Verifica se existe um StatusAluno com o ID passado por parâmetro
     * na base de dados.
     * @param id O id do StatusAluno a ser consultado.
     * @return 'true' caso haja um StatusAluno com o Id
     * passado por parâmetro na base de dados,
     * 'false' caso contrário.
     */
    boolean existsById(Long id);

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra uma StatusAluno pelo ID passado por parâmetro.
     * @param id O ID da StatusAluno a ser encontrado.
     * @return um objeto opcional do tipo StatusAluno,
     * que será nulo caso o requisição não exista na base de dados.
     */
    Optional<StatusAluno> findById(Long id);
}
