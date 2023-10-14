package br.com.ifba.controller.v1;

import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.formulario.dto.FormularioRequestDto;
import br.com.ifba.entity.formulario.model.Formulario;
import br.com.ifba.entity.usuario.dto.UsuarioRequestDto;
import br.com.ifba.entity.usuario.dto.UsuarioResponseDto;
import br.com.ifba.entity.usuario.model.Usuario;
import br.com.ifba.entity.usuario.service.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

/**
 * 
 * 
 * @author Andesson reis
 *         Desde V1.0.1
 */

@RestController
@RequestMapping(path = "/apif/v1")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @RequestMapping(path = "/usuarios")
    public ResponseEntity<?> getUsuarios() {
        try {
            List<UsuarioResponseDto> usuarios = usuarioService.getAllUsuariosDto();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            HashMap<String, String> erro = new HashMap<>();
            erro.put("error", "Não foi possível obter a lista de usuários.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
        }
    }

    @RequestMapping(path = "/usuario/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable Long id) {
        try {
            UsuarioResponseDto usuario = usuarioService.findById(id);
            return ResponseEntity.ok(usuario);
        } catch (NoSuchElementException e) {
            HashMap<String, String> erro = new HashMap<>();
            erro.put("error", "Usuário não encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        } catch (Exception e) {
            HashMap<String, String> erro = new HashMap<>();
            erro.put("error", "Não foi possível obter o usuário.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
        }
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
                .body(usuarioService.saveUsuario(Usuario.fromRequestDto(usuarioDto)));

    }

}