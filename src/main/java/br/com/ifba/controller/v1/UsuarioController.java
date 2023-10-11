package br.com.ifba.controller.v1;

import br.com.ifba.entity.usuario.dto.UsuarioRequestDto;
import br.com.ifba.entity.usuario.dto.UsuarioResponseDto;
import br.com.ifba.entity.usuario.model.Usuario;
import br.com.ifba.entity.usuario.service.IServiceUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/apif/v1")
public class UsuarioController {

    @Autowired
    IServiceUsuario serviceUsuario;

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
/* 
@RequestMapping(path = "/salvarUsuario", method = RequestMethod.POST)
    public Usuario salvarUsuario(@RequestBody String usuario) {
        Usuario user = (Usuario) gson.fromJson(usuario, Usuario.class);
        return serviceUsuario.saveUsuario(user);
    }
*/