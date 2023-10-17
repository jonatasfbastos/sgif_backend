package br.com.ifba.entity.perfilusuario.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.perfilusuario.dto.PerfilUsuarioRequestDto;
import br.com.ifba.entity.perfilusuario.dto.PerfilUsuarioResponseDto;
import br.com.ifba.entity.permissao.model.Permissao;
import br.com.ifba.entity.usuario.dto.UsuarioResponseDto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Esta classe representa um perfil de usuário.
 *
 * @author Igor Lopes
 * @edited by tarciiz
 * @edited by Andesson Reis
 * 
 * @since V1.0.1
 * 
 * Veja também: {@link br.com.ifba.entity.usuario}
 */
@Entity(name = "perfilusuario")
@Table(name = "perfilusuarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
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

    @OneToMany(mappedBy = "perfilUsuario", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE })
    private List<UsuarioResponseDto> usuarios;


    public PerfilUsuario(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

}