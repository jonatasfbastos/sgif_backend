package br.com.ifba.sgif.api.entity.permissaolink.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import br.com.ifba.sgif.api.entity.permissao.model.Permissao;
import br.com.ifba.sgif.api.infrastructure.model.PersistenceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
 */

@Entity(name = "permissaoLink")
@Table(name = "permissao_links")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class PermissaoLink extends PersistenceEntity implements Serializable {

    /**
     * O nome do link de permissão.
     */

    @Column(nullable = false)
    private String nome;

    /**
     * A URL associada ao link de permissão.
     */

    @Column(nullable = false)
    private String url;

    /**
     * Permissões relacionadas a este link.
     */

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "link_permissao",
        joinColumns = @JoinColumn(name = "link_id"),
        inverseJoinColumns = @JoinColumn(name = "permissao_id"))
    @JsonIgnoreProperties("links")
    private List<Permissao> permissoes;

}
