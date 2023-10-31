
package br.com.ifba.entity.notificacao.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.notificacao.model.Notificacao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tarciiz
 */
@Repository
public interface IDaoNotification extends JpaRepository<Notificacao, UUID> {

    List<Notificacao> findByReaded(boolean readed);

    Optional<Notificacao> findById(UUID id);

    Notificacao findByWhatIdAndWhatObjectName(UUID whatId, String whatObjectName);
}