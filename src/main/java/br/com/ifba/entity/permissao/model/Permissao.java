package br.com.ifba.entity.permissao.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.permissaolink.model.PermissaoLink;
import br.com.ifba.entity.perfilusuario.model.PerfilUsuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

/**
 * Esta classe representa uma permissão.
 *
 * @author unknown
 * Editado por Andesson Reis
 * @since V1.0.1
 * 
 * Veja também: {@link br.com.ifba.entity.permissao.model.PermissaoLink}
 */
@Entity(name = "permissao")
@Data
@Table(name = "permissao")
@EqualsAndHashCode(callSuper = false)
public class Permissao extends PersistenceEntity implements Serializable {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @NotBlank(message = "O nome da permissão não pode ser vazio.")
    private String nome;

    private boolean grupo;

    private String icone;

    @JsonIgnore
    @ManyToMany(mappedBy = "permissoes", fetch = FetchType.LAZY)
    private List<PerfilUsuario> perfis;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<PermissaoLink> links;
}
