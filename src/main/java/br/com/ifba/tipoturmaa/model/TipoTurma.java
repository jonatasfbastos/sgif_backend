package br.com.ifba.tipoturmaa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.turma.model.Turma;
import lombok.Data;

@Entity
@Table(name = "tipo_turma")
@Data
public class TipoTurma extends PersistenceEntity implements Serializable{
    
    private String nome;
    private String descricao;
    @OneToMany(mappedBy = "tipoTurma", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Turma> turmas;
    
}
