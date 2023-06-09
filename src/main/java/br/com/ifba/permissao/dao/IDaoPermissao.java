package br.com.ifba.permissao.dao;

import br.com.ifba.permissao.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IDaoPermissao extends JpaRepository<Permissao, Long> {

    boolean existsByNome(String url);
    List<Permissao> findByPerfisId(Long id);
    List<Permissao> findByLinksId(Long id);

}