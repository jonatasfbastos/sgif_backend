
package br.com.ifba.sgif.api.entity.notificacao.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.notificacao.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author tarciiz
 */
@Repository
public interface IDaoNotification extends JpaRepository<Notificacao, UUID> {

    List<Notificacao> findByLido(boolean status);

    Optional<Notificacao> findById(UUID id);

    Notificacao findByQualIdAndQualNomeObjeto(UUID id, String nomeObjeto);
}