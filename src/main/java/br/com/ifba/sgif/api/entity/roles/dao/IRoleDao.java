package br.com.ifba.sgif.api.entity.roles.dao;

import br.com.ifba.sgif.api.entity.roles.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IRoleDao extends JpaRepository<Role, UUID> {
}
