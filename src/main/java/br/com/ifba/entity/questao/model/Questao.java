package br.com.ifba.entity.questao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.ifba.infrastructure.model.PersistenceEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Esta classe representa uma questão de um formulário.
 * Ela contém informações sobre o enunciado da questão e a resposta, sendo que a resposta inicialmente é nula.
 */
@Entity(name = "questao")
@Table(name = "questoes")
@Data
@EqualsAndHashCode(callSuper = false)
public class Questao extends PersistenceEntity implements Serializable{

    /**
     * O enunciado da questão, não aceita valores nulos.
     */
    @Column(name = "enunciado")
    private String enunciado;

    /**
     * AVISO: futuramente este atributo será a instância de uma lista da classe 'Resposta',
     * pois será necessário identificar o conteúdo da reposta e o dono da resposta.
     * No contexto atual, não é considerada a hipotese que uma questão,
     * que será distribuida pora diversos usuários, possui mais de uma resposta.
     */
    @Column(name = "resposta", nullable = false)
    private String resposta;
    
}
