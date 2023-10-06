package br.com.ifba.entity.questao.service;

import java.util.List;

import br.com.ifba.entity.questao.model.Questao;

public interface IServiceQuestao {
    
    //salva a Questao
    public abstract Questao saveQuestao(Questao questao);
    
    //atualiza a Questao
    public abstract Questao updateQuestao(Questao questao);
    
    //deleta a Questao
    public abstract void deleteQuestao(Questao questao);
    
    // Metodo que retorna todas as Questaos da base de dados
    public abstract List<Questao> getAllQuestao();
    
    // Método que retorna a Questao com o id informado
    public Questao findById(Long id);
    
    // Método que retorna a lista com as Questaos com o enunciado informado
    public List<Questao> findByEnunciado(String enunciado);

}
