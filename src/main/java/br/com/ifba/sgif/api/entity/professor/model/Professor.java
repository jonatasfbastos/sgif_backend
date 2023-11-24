package br.com.ifba.sgif.api.entity.professor.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

import br.com.ifba.sgif.api.entity.disciplina.model.Disciplina;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifba.sgif.api.entity.servidor.model.Servidor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "professor")
@Data
@EqualsAndHashCode(callSuper = false)

public class Professor extends Servidor implements Serializable{
    @JsonIgnore
    @ManyToMany(mappedBy = "professor", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Disciplina> disciplinas;
}
