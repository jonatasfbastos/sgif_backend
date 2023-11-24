package br.com.ifba.sgif.api.entity.perfilusuario.dao;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.sgif.api.entity.perfilusuario.model.PerfilUsuario;

/**
 *
 * @author Igor Lopes e Eduarda
 */
@Repository
public interface IDaoPerfilUsuario extends JpaRepository<PerfilUsuario, UUID> {
   List<PerfilUsuario> findByNome(String name);
   List<PerfilUsuario> findByPermissoesId(UUID id);
   Optional<PerfilUsuario> findById(UUID id);

}