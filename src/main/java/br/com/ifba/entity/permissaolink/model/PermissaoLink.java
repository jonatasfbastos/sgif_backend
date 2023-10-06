package br.com.ifba.entity.permissaolink.model;

import br.com.ifba.entity.permissao.model.Permissao;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "permissao_link")
public class PermissaoLink extends PersistenceEntity implements Serializable {

    private String nome;
    private String url;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "links")
    private List<Permissao> permissoes;

}