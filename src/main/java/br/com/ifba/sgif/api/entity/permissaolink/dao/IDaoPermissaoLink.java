package br.com.ifba.sgif.api.entity.permissaolink.dao;

import br.com.ifba.sgif.api.entity.permissaolink.model.PermissaoLink;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IDaoPermissaoLink extends JpaRepository<PermissaoLink, UUID> {

    boolean existsByUrl(String url);

    List<PermissaoLink> findByPermissoesId(UUID id);

    Optional<PermissaoLink> findById(UUID id);
}