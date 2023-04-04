package br.com.ifba.tipoturmaa.service;

import java.util.List;

import br.com.ifba.tipoturmaa.model.TipoTurma;

public interface IServiceTipoTurma {
     // Salva Tipoturma.
     public abstract TipoTurma saveTipoTurma(TipoTurma tipoturma);
     // Atualiza TipoTurma.
     public abstract TipoTurma updateTipoTurma(TipoTurma ttipourma);
     // Deleta TipoTurma.
     public abstract void deleteTipoTurma(TipoTurma turma);
      // MetÃ©odo que retorna todos as TipoTurmas da base de dados.
     public abstract List<TipoTurma> getAllTipoTurma();
     // MÃ©todo que retorna a Tipoturma com o id informado.
     public TipoTurma findById(Long id);
     // MÃ©todo que retorna a lista com as Tipoturmas com o nome informado.
     public List<TipoTurma> findByNome(String nome);
}
