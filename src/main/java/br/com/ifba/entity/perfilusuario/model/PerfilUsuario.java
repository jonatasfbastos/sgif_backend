package br.com.ifba.entity.perfilusuario.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.perfilusuario.dto.PerfilUsuarioRequestDto;
import br.com.ifba.entity.perfilusuario.dto.PerfilUsuarioResponseDto;
import br.com.ifba.entity.permissao.model.Permissao;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Esta classe representa um perfil de usuário.
 *
 * @author Igor Lopes
 * @edited by tarciiz
 * @edited by Andesson Reis
 * 
 */
@Entity
@Table(name = "perfilusuario")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class PerfilUsuario extends PersistenceEntity {

    @NotBlank(message = "O nome do perfil não pode ser vazio.")
    private String nome;

    @NotBlank(message = "A descrição do perfil não pode ser vazia.")
    private String descricao;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Permissao> permissoes;

    // @OneToMany(mappedBy = "perfilUsuario", fetch = FetchType.LAZY, cascade = {
    // CascadeType.PERSIST, CascadeType.MERGE })
    // private List<Usuario> usuarios;


    public PerfilUsuario(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }


    /**
     *
     * @author Andesson reis
     *
     * Fábrica de objeto PerfilUsuario.
     *
     * @param perfilUsuarioDto - O objeto de transferência com dados do Perfil Usuario;
     * @return um objeto PerfilUsuario.
     */
    public static PerfilUsuario fromRequestDto(PerfilUsuarioRequestDto perfilUsuarioDto){

        return new PerfilUsuario(
                perfilUsuarioDto.nome(),
                perfilUsuarioDto.descricao()
        );

    }

    /**
     * @author Andesson Reis
     *
     * Cria um objeto de resposta DTO para ser enviado no ResponseBody
     * das requisições direcionada à entidade 'PerfilUsuario'.
     *
     * @return um objeto PerfilUsuarioResponseDto com dados do formulário.
     */
    public PerfilUsuarioResponseDto toResponseDto(){

        return new PerfilUsuarioResponseDto(this.nome, this.descricao);
    }

}