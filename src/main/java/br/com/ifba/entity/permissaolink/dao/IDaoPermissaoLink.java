package br.com.ifba.entity.permissaolink.dao;

import br.com.ifba.entity.permissaolink.model.PermissaoLink;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IDaoPermissaoLink extends JpaRepository<PermissaoLink, Long> {

    boolean existsByUrl(String url);
    List<PermissaoLink> findByPermissoesId(Long id);

}