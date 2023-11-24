package br.com.ifba.sgif.api.entity.permissao.dao;

import br.com.ifba.sgif.api.entity.permissao.model.Permissao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IDaoPermissao extends JpaRepository<Permissao, UUID> {

    boolean existsByNome(String url);
    List<Permissao> findByPerfisId(UUID id);
    List<Permissao> findByLinksId(UUID id);
    Optional<Permissao> findById(UUID id);

}