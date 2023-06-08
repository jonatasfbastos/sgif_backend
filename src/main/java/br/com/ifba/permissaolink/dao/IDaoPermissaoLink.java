package br.com.ifba.permissaolink.dao;

import br.com.ifba.permissaolink.model.PermissaoLink;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IDaoPermissaoLink extends JpaRepository<PermissaoLink, Long> {

    boolean existsByUrl(String url);
    List<PermissaoLink> findByPermissoesId(Long id);

}