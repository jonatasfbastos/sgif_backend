package br.com.ifba.controller.v1;

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


    @PostMapping(path = "/usuarios/usuario")
    public ResponseEntity<?> salvarUsuario(@Valid @RequestBody UsuarioRequestDto usuarioDto, BindingResult result) {
        if (result.hasErrors()) {
            HashMap<String, String> erros = new HashMap<>();

            for (FieldError erro : result.getFieldErrors()) {
                erros.put(erro.getField(), erro.getDefaultMessage());
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Usuario.fromRequestDto(usuarioDto).toResponseDto());
    }
}


