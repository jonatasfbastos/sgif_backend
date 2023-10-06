package br.com.ifba.entity.permissao.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.permissaolink.model.PermissaoLink;
import br.com.ifba.entity.perfilusuario.model.PerfilUsuario;
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
@Table(name = "permissao")
public class Permissao extends PersistenceEntity implements Serializable {

    private String nome;
    private boolean grupo;
    private String icone;

    @JsonIgnore
    @ManyToMany(mappedBy = "permissoes", fetch = FetchType.LAZY)
    private List<PerfilUsuario> perfis;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<PermissaoLink> links;

}