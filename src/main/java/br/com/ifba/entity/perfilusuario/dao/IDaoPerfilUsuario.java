package br.com.ifba.entity.perfilusuario.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.entity.perfilusuario.model.PerfilUsuario;

/**
 *
 * @author Igor Lopes e Eduarda
 */
@Repository
public interface IDaoPerfilUsuario extends JpaRepository<PerfilUsuario, Long> {
   List<PerfilUsuario> findByNome(String name);
   List<PerfilUsuario> findByPermissoesId(Long id);

}