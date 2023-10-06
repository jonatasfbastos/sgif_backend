package br.com.ifba.entity.tecnicoadministrativo.model;

import br.com.ifba.entity.funcaoservidor.model.FuncaoServidor;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.ifba.entity.funcaotecnicoadministrativo.model.FuncaoTecnicoAdministrativo;
import br.com.ifba.entity.servidor.model.Servidor;
import javax.persistence.FetchType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tecnicoadminstrativo")
@Data
@EqualsAndHashCode(callSuper = false)
public class TecnicoAdministrativo extends Servidor implements Serializable{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "funcao_id", referencedColumnName = "ID")
    private FuncaoServidor funcao;
    
    @ManyToOne
    @JoinColumn(name = "tecnicoAdministrativo_id")
    @JsonIgnoreProperties("tecnicoAdministrativos")
    private FuncaoTecnicoAdministrativo funcaoTecnicoAdministrativo;

}
