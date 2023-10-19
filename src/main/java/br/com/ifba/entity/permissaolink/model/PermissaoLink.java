package br.com.ifba.entity.permissaolink.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import br.com.ifba.entity.permissao.model.Permissao;
import br.com.ifba.infrastructure.model.PersistenceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/* 
 * @author Andesson Reis
 * @since V1.0.1
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
