package br.com.ifba.sgif.api.entity.funcaotecnicoadministrativo.model;

import br.com.ifba.sgif.api.infrastructure.model.PersistenceEntity;
import br.com.ifba.sgif.api.entity.tecnicoadministrativo.model.TecnicoAdministrativo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * Esta classe representa uma função de técnico administrativo.
 *
 * @author unknown
 * Editado por Andesson Reis
 * @since V1.0.1
 * 
 * Esta classe representa uma função de técnico administrativo da organização.
 * Nenhum dos atributos desta classe pode ser nulo.
 * 
 * Veja também: {@link TecnicoAdministrativo}
 */
@Entity(name = "funcao_tecnico_administrativo")
@Table(name = "funcoes_tecnico_administrativo")
@Data
@EqualsAndHashCode(callSuper = false)
public class FuncaoTecnicoAdministrativo extends PersistenceEntity implements Serializable {

    /**
     * O nome da função de técnico administrativo. Não pode ser nulo.
     */
    @NotNull
    private String nome;

    /**
     * A descrição da função de técnico administrativo.
     */
    private String descricao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcaoTecnicoAdministrativo")
    private List<TecnicoAdministrativo> tecnicoAdministrativos;
}
