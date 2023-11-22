package br.com.ifba.controller.v1;

import br.com.ifba.entity.usuario.dto.UsuarioRequestDto;
import br.com.ifba.entity.usuario.model.Usuario;
import br.com.ifba.infrastructure.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;

import javax.validation.Valid;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class LoginController {

    //@Autowired
    //TokenService tokenService;

    //@Autowired
    //AuthenticationManager authenticationManager;

    /**
     * Tenta fazer login com informações de usuário.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param usuarioDto DTO com informações do usuário a ser autenticado.
     * @return uma entidade de resposta genérica.
     */
    /*@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> fazerLogin(@Valid @RequestBody UsuarioRequestDto usuarioDto){

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(usuarioDto.login(), usuarioDto.senha());

        Authentication autenticado =
                this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var usuario = (Usuario) autenticado.getPrincipal();

        return ResponseEntity.status(HttpStatus.OK)
                .body(tokenService.gerarToken(usuario));

    }
*/
}
