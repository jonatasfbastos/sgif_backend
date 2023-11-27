package br.com.ifba.sgif.api.entity.permissao.dao;

import br.com.ifba.sgif.api.entity.permissao.model.Permissao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IDaoPermissao extends JpaRepository<Permissao, Long> {

    boolean existsByNome(String url);
    List<Permissao> findByPerfisId(Long id);
    List<Permissao> findByLinksId(Long id);
    Optional<Permissao> findById(Long id);

}