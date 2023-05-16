package br.com.ifba.professor.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ifba.disciplina.model.Disciplina;
import br.com.ifba.servidor.model.Servidor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "professor")
@Data
@EqualsAndHashCode(callSuper = false)

public class Professor extends Servidor implements Serializable{
    @OneToMany(mappedBy = "professor", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Disciplina> disciplina;
}
