package br.com.ifba.etapacursoo.service;

import java.util.List;

import br.com.ifba.etapacursoo.model.EtapaCurso;

public interface IServiceEtapaCurso {
     // Salva EtapaCurso
     public abstract EtapaCurso saveEtapaCurso(EtapaCurso etapaCurso);
     // Atualiza EtapaCurso
     public abstract EtapaCurso updateEtapaCurso(EtapaCurso etapaCurso);
     // Deleta EtapaCurso
     public abstract void deleteEtapaCurso(EtapaCurso etapaCurso);
      // MÃ©todo que retorna todos as EtapaCurso salvos no base de dados
     public abstract List<EtapaCurso> getAllEtapaCurso();
     // MÃ©todo que retorna a EtapaCurso com o id informado
     public EtapaCurso findById(Long id);
     // MÃ©todo que retorna a lista com as EtapaCurso com o nome informado
     public List<EtapaCurso> findByNome(String nome);
}
