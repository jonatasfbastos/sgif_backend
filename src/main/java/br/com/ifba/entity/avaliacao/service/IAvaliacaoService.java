package br.com.ifba.entity.avaliacao.service;

import java.util.List;

import br.com.ifba.entity.avaliacao.model.Avaliacao;

public interface IServiceAvaliacao {
    
    // Salva Disponibilizar Avaliacao.
    public Avaliacao saveAvaliacao(Avaliacao avaliacao);
    // Atualiza  Disponibilizar Avaliacao.
    public Avaliacao updateAvaliacao(Avaliacao avaliacao);
    // Deleta o Disponibilizar Avaliacao.
    public void deleteAvaliacao(Avaliacao avaliacao);
     // MÃ©todo que retorna todos os Disponibilizar Avaliacao da base de dados.
    public List<Avaliacao> getAllAvaliacao();
    // MÃ©todo que retorna o Disponibilizar Avaliacao com o id informado.
    public Avaliacao findById(Long id);
    public List<Avaliacao> filtrarAvaliacao(String dtInicio, String dtFim, Long idDisciplina);
    
}
