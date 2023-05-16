package br.com.ifba.tecnicoadministrativo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.ifba.funcaotecnicoadministrativo.model.FuncaoTecnicoAdministrativo;
import br.com.ifba.servidor.model.Servidor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tecnicoadminstrativo")
@Data
@EqualsAndHashCode(callSuper = false)
public class TecnicoAdministrativo extends Servidor implements Serializable{

    @ManyToOne
    @JoinColumn(name = "tecnicoAdministrativo_id")
    @JsonIgnoreProperties("tecnicoAdministrativos")
    private FuncaoTecnicoAdministrativo funcaoTecnicoAdministrativo;

}
