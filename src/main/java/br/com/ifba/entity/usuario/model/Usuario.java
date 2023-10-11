package br.com.ifba.entity.usuario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import br.com.ifba.entity.perfilusuario.dto.PerfilUsuarioResponseDto;
import br.com.ifba.entity.perfilusuario.model.PerfilUsuario;
import br.com.ifba.entity.usuario.dto.UsuarioRequestDto;
import br.com.ifba.entity.usuario.dto.UsuarioResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Esta classe, descendente da classe Pessoa, representa um usuario.
 * Nenhum dos atributos desta classes pode ser nulo.
 */

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Usuario extends PersistenceEntity {

    /**
     * O nome de usuário do usuário. Não pode ser nulo.
     */

    @Column(nullable = false, unique = true)
    private String login;

    /**
     * A senha do usuário. Não pode ser nula.
     */

    @NotNull
    private String password;

    /**
     * Perfil do usuario.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "perfil_usuario_id", referencedColumnName = "ID")
    @JsonIgnoreProperties("usuarios")
    private PerfilUsuario perfilUsuario;

    /**
     *
     * @author Andesson Reis
     *
     *Fábrica de objeto Usuario.
     *
     * @param usuarioDto - O objeto de transferência com dados do Usario;
     * @return um objeto Usuario.
     */

    public static Usuario fromRequestDto(UsuarioRequestDto usuarioDto) {

        return new Usuario(
                usuarioDto.login(),
                usuarioDto.senha(),
                new PerfilUsuario(
                        usuarioDto.perfilUsuario().nome(),
                        usuarioDto.perfilUsuario().descricao())
                        );
    }

    /**
     * @author Andesson Reis
     *
     * Cria um objeto de resposta DTO para ser enviado no ResponseBody
     * das requisições direcionada à entidade 'Usuario'.
     *
     * @return um objeto UsuarioResponseDto com dados do formulário.
     */

     public UsuarioResponseDto toResponseDto() {
        PerfilUsuarioResponseDto perfilDto = new PerfilUsuarioResponseDto(
            this.login,  
            this.password 
        );
    
        return new UsuarioResponseDto(this.login, this.password, perfilDto);
    }
    

}