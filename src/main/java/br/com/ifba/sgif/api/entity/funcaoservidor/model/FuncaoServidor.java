package br.com.ifba.sgif.api.entity.funcaoservidor.model;

import br.com.ifba.sgif.api.infrastructure.model.PersistenceEntity;
import br.com.ifba.sgif.api.entity.servidor.model.Servidor;
import br.com.ifba.sgif.api.entity.tecnicoadministrativo.model.TecnicoAdministrativo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.FetchType;
import java.io.Serializable;
import java.util.List;

/**
 * Esta classe representa uma função de servidor.
 *
 * @author Gusd
 * Editado por Andesson Reis
 * @since V1.0.1
 * 
 * Esta classe representa uma função de servidor da organização.
 * Nenhum dos atributos desta classe pode ser nulo.
 * 
 * Veja também: {@link Servidor}
 */
@Entity(name = "funcao_servidor")
@Table(name = "funcoes_servidor")
@Data
@EqualsAndHashCode(callSuper = false)
public class FuncaoServidor extends PersistenceEntity implements Serializable {

    /**
     * O nome da função de servidor. Não pode ser nulo.
     */
     @Column(nullable = false)
    private String nome;

    /**
     * A descrição da função de servidor.
     */
    @NotNull
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcaoServidor")
    private List<Servidor> servidores;
    
    @JsonIgnore
    @OneToMany(mappedBy = "funcao", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TecnicoAdministrativo> tecnicoAdministrativos;
}
