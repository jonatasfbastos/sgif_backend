package br.com.ifba.funcaotecnicoadministrativo.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.tecnicoadministrativo.model.TecnicoAdministrativo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "funcao_tecnico_administrativo")
@EqualsAndHashCode(callSuper = false)
public class FuncaoTecnicoAdministrativo extends PersistenceEntity implements Serializable {

    private String nome;
    private String descricao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcaoTecnicoAdministrativo")
    private List<TecnicoAdministrativo> tecnicoAdministrativos;

}