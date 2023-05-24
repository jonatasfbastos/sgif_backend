/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.statusaluno.model;

import br.com.ifba.aluno.model.Aluno;
import br.com.ifba.funcaoservidor.model.FuncaoServidor;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Ellen Cristina
 */
@Entity
@Table(name = "statusaluno")
@Data
@EqualsAndHashCode(callSuper = false)
public class StatusAluno extends PersistenceEntity implements Serializable{
    private String nome;
    private String descricao;
    
    @JsonIgnore
    @OneToMany(mappedBy = "statusAluno", fetch = FetchType.EAGER)
    private List<Aluno> alunos;
}
