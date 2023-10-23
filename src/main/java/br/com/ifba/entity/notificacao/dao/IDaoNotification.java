
package br.com.ifba.entity.notification.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifba.entity.notification.model.Notification;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tarciiz
 */
@Repository
public interface IDaoNotification extends JpaRepository<Notification, Long> {

    List<Notification> findByReaded(boolean readed);

    Optional<Notification> findById(Long id);

    Notification findByWhatIdAndWhatObjectName(Long whatId, String whatObjectName);
}