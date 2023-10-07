package br.com.ifba.entity.setor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifba.entity.setor.model.Setor;

/**
 *
 * @author Everton.
 */
@Repository
public interface IDaoSetor extends JpaRepository<Setor, Long> {

   List<Setor> findByNome(String name);

}
