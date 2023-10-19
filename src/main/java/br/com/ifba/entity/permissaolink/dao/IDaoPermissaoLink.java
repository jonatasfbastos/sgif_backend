package br.com.ifba.entity.permissaolink.dao;

import br.com.ifba.entity.permissaolink.model.PermissaoLink;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IDaoPermissaoLink extends JpaRepository<PermissaoLink, Long> {

    boolean existsByUrl(String url);

    List<PermissaoLink> findByPermissoesId(UUID id);

    Optional<PermissaoLink> findById(UUID id);
}