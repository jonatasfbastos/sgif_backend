package br.com.ifba.funcaoservidor.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.servidor.model.Servidor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Gusd
 */
@Entity
@Data
@Table(name = "funcao_servidor")
@EqualsAndHashCode(callSuper = false)
public class FuncaoServidor extends PersistenceEntity implements Serializable {

    private String nome;
    private String descricao;
    @JsonIgnore
    @OneToMany(mappedBy="funcaoServidor")
    private List<Servidor> servidor;

}