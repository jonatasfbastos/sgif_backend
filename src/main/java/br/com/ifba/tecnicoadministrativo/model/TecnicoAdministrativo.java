package br.com.ifba.tecnicoadministrativo.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.ifba.funcaotecnicoadministrativo.model.FuncaoTecnicoAdministrativo;
import br.com.ifba.servidor.model.Servidor;
import lombok.Data;

@Entity
@Table(name = "tecnicoadminstrativo")
@Data
public class TecnicoAdministrativo extends Servidor implements Serializable{

    @ManyToMany
    private List<FuncaoTecnicoAdministrativo> funcaoTecnicoAdministrativo;

}
