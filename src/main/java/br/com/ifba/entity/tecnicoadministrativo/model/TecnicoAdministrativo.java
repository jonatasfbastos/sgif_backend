package br.com.ifba.entity.tecnicoadministrativo.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.ifba.entity.funcaoservidor.model.FuncaoServidor;
import br.com.ifba.entity.funcaotecnicoadministrativo.model.FuncaoTecnicoAdministrativo;
import br.com.ifba.entity.servidor.model.Servidor;

import java.io.Serializable;
import javax.persistence.FetchType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Esta classe representa um técnico administrativo.
 * 
 * @author unknown
 * @since V1.0.1
 * @Editado por Andesson Reis
 * 
 * Esta classe representa um técnico administrativo da organização.
 * Nenhum dos atributos desta classe pode ser nulo.
 * 
 * Veja também: {@link br.com.ifba.entity.funcaoservidor.model.FuncaoServidor}
 * Veja também: {@link br.com.ifba.entity.funcaotecnicoadministrativo.model.FuncaoTecnicoAdministrativo}
 */
@Entity(name = "tecnicoadministrativo")
@Table(name = "tecnicos_administrativos")
@Data
@EqualsAndHashCode(callSuper = false)
public class TecnicoAdministrativo extends Servidor implements Serializable {

    /**
     * A função de servidor do técnico administrativo. Não pode ser nula.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "funcao_id", referencedColumnName = "ID")
    private FuncaoServidor funcao;

    /**
     * A função de técnico administrativo. Não pode ser nula.
     */
    @ManyToOne
    @JoinColumn(name = "funcaoTecnicoAdministrativo_id")
    @JsonIgnoreProperties("tecnicoAdministrativos")
    private FuncaoTecnicoAdministrativo funcaoTecnicoAdministrativo;
}
