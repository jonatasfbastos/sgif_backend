package br.com.ifba.controller.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.perfilusuario.dto.PerfilUsuarioRequestDto;
import br.com.ifba.entity.perfilusuario.model.PerfilUsuario;
import br.com.ifba.entity.perfilusuario.service.IServicePerfilUsuario;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * 
 * 
 * @author Andesson reis
 *         Desde V1.0.1
 */

@RestController
@RequestMapping(path = "/apif/v1")
public class PerfilUsuarioController {

    // =========================================================== //
    // =============== [ ATRIBUTOS ] ============================= //
    // =========================================================== //
    @Autowired
    IServicePerfilUsuario perfilUsuarioService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ ENDPOINTS ] ============================= //
    // =========================================================== //

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     *          Obtém a lista de todos os Perfis de usuários.
     * 
     * @return Uma lista de perfis de usuários ou uma resposta de erro em caso de
     *         falha.
     * 
     * @author Andesson Reis
     */

    @GetMapping(path = "/perfilUsuarios", consumes = "application/json")
    public ResponseEntity<?> getPerfilUsuarios() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(perfilUsuarioService.getAllPerfilUsuario());
    }

    /**
     * @author Andesson Reis
     *
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Salva um perfil Usuario.
     * @return uma entidade de resposta generica.
     */

    @PostMapping(path = "/perfilUsuarios/perfilUsuario", consumes = "application/json")
    public ResponseEntity<?> salvarPerfilUsuario(@Valid @RequestBody PerfilUsuarioRequestDto perfilUsuarioDto, BindingResult result) {

        PerfilUsuario perfilUsuario = objectMapperUtil.map(perfilUsuarioDto, PerfilUsuario.class);
    
        return result.hasErrors()
            ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
            : ResponseEntity.status(HttpStatus.CREATED)
            .body(perfilUsuarioService.savePerfilUsuario(perfilUsuario));

    }

}