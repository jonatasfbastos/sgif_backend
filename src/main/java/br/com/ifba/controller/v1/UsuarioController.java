package br.com.ifba.controller.v1;

import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.usuario.dto.UsuarioRequestDto;
import br.com.ifba.entity.usuario.model.Usuario;
import br.com.ifba.entity.usuario.service.IUsuarioService;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 
 * 
 * @author Andesson reis
 * Desde V1.0.1
 */

@RestController
@RequestMapping(path = "/apif/v1")
public class UsuarioController {

    // =========================================================== //
    // =============== [ ATRIBUTOS ] ============================= //
    // =========================================================== //
    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ ENDPOINTS ] ============================= //
    // =========================================================== //

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Obtém a lista de todos os usuários.
     * 
     * @return Uma lista de usuários ou uma resposta de erro em caso de falha.
     * 
     * @author Andesson Reis
     */
    @GetMapping(path = "/usuarios", consumes = "application/json")
    public ResponseEntity<?> getUsuarios() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(usuarioService.getAllUsuarios());
    }

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Obtém um usuário.
     *
     * @return Um usuário ou uma resposta de erro em caso de falha.
     *
     * @author Andesson Reis
     */
    @GetMapping(path = "/usuario/{id}", consumes = "application/json")
    public ResponseEntity<?> getUsuario(@Valid @PathVariable("id") @NotNull UUID id) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(usuarioService.findById(id));
    }

     /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Obtém um usuario por login(username) e senha.
     * 
     * @return Uma lista um usuário ou uma resposta de erro em caso de falha.
     * 
     * @author Andesson Reis
     */
    @GetMapping(path = "/usuarios/login", consumes = "application/json")
    public ResponseEntity<?> getUsuarioByLoginAndSenha(@Valid @PathVariable("login") String login, @PathVariable("senha") String senha) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(usuarioService.findByLoginAndSenha(login, senha));
    }

    /**
     * @author Andesson Reis
     *
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Salva um Usuario.
     * @return uma entidade de resposta generica.
     */

    @PostMapping(path = "/usuarios/usuario", consumes = "application/json")
    public ResponseEntity<?> salvarUsuario(@Valid @RequestBody UsuarioRequestDto usuarioDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED)
                        .body(usuarioService.saveUsuario(objectMapperUtil.map(usuarioDto, Usuario.class)));

    }

    /**
     * @author Andesson Reis
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Deleta um usuario.
     * @return uma entidade de resposta generica.
     */
    @DeleteMapping(path = "/usuarios/usuario/{id}", consumes = "application/json")
    public ResponseEntity<?> deletarUsuarioPorID(@Valid @PathVariable("id") @NotNull UUID id) {

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(usuarioService.deleteUsuario(id));
    }

}