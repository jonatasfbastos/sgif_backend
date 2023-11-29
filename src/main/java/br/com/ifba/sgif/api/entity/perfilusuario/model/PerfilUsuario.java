package br.com.ifba.sgif.api.entity.perfilusuario.model;

import br.com.ifba.sgif.api.infrastructure.model.PersistenceEntity;
import br.com.ifba.sgif.api.entity.permissao.model.Permissao;
import br.com.ifba.sgif.api.entity.usuario.model.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.*;

import java.util.List;

/**
 * Esta classe representa um perfil de usuário.
 *
 * @author Igor Lopes
 * edited by tarciiz
 * edited by Andesson Reis
 * 
 * @since V1.0.1
 * 
 * Veja também: {@link br.com.ifba.entity.usuario}
 */
@Entity(name = "perfilusuario")
@Table(name = "perfilusuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PerfilUsuario extends PersistenceEntity {
    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //
    
    /**
     * O nome de usuário do perfil.
     */
    @NotBlank(message = "O nome do perfil não pode ser vazio.")
    private String nome;

    /**
     * Descrição do usuario
     */
    @NotBlank(message = "A descrição do perfil não pode ser vazia.")
    private String descricao;

     /**
     *Permissões do usuario
     */
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Permissao> permissoes;

    @OneToMany(mappedBy = "perfilUsuario", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE })
    private List<Usuario> usuarios;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    @Override
    public String toString() {
        return "";
    }
}