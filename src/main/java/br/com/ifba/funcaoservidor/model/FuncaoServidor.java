package br.com.ifba.funcaoservidor.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.servidor.model.Servidor;
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
@Table(name = "funcao_servidor")
@EqualsAndHashCode(callSuper = false)
public class FuncaoServidor extends PersistenceEntity implements Serializable {

    private String nome;
    private String descricao;
    @JsonIgnore
    @ManyToMany(mappedBy = "funcaoservidor", fetch = FetchType.LAZY)
    private List<Servidor> servidor;

}