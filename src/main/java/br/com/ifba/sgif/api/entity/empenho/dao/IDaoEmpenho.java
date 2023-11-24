/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package br.com.ifba.sgif.api.entity.empenho.dao;

import java.util.Optional;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.empenho.model.Empenho;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author rocki.julius
 */
public interface IDaoEmpenho extends JpaRepository<Empenho, UUID> {
       /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra um Empenho pelo ID passado por parâmetro.
     * @param id O ID do Empenho a ser enconotrado.
     * @return um objeto opcional do tipo Empenho,
     * que será nulo caso o Empenho não exista na base de dados.
     */
    Optional<Empenho> findById(UUID id);

      /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Verifica se existe um Empenho com o ID passado por parâmetro
     * na base de dados.
     * @param id O id do Empenho a ser consultado.
     * @return 'true' caso haja um Empenho com o Id
     * passado por parâmetro na base de dados,
     * 'false' caso contrário.
     */
    boolean existsById(UUID id);
}