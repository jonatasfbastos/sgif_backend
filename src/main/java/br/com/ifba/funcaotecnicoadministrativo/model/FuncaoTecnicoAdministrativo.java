package br.com.ifba.funcaotecnicoadministrativo.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.tecnicoadministrativo.model.TecnicoAdministrativo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
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
    @JsonIgnore
    @ManyToMany(mappedBy = "funcaoTecnicoAdministrativo", fetch = FetchType.LAZY)
    private List<TecnicoAdministrativo> tecnicoAdministrativo;

}