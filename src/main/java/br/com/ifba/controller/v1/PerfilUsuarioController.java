package br.com.ifba.controller.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
 * Desde V1.0.1
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
     * Obtém a lista de todos os Perfis de usuários.
     * 
     * @return Uma lista de perfis de usuários ou uma resposta de erro em caso de falha.
     *         
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
     * Desde V1.0.1
     * 
     * Encontra perfis de usuário (Response DTO) pelo nome.
     *
     * @param name O nome a ser pesquisado.
     * @return Uma lista de perfis de usuário (Response DTO) com o nome especificado ou uma resposta de erro em caso de falha
     *        
     */
    @GetMapping(path = "/perfilUsuarios/login", consumes = "application/json")
    public ResponseEntity<?> getPerfilUsuariosPorNome(@PathVariable String nome) {
        
        return ResponseEntity.status(HttpStatus.OK)
                .body(perfilUsuarioService.findByNome(nome));
   
    }

      /**
     * @author Andesson Reis
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Atualiza um perfil de usuario.
     * @return uma entidade de resposta generica.
     */
    @PutMapping(path = "/perfilUsuarios/perfilUsuario", consumes = "application/json")
    public ResponseEntity<?> atualizarPerfilUsuario(@RequestBody PerfilUsuarioRequestDto perfilUsuarioDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(perfilUsuarioService
                .updatePerfilDeUsuario(objectMapperUtil.map(perfilUsuarioDto, PerfilUsuario.class)));

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

     /**
     * @author Andesson Reis
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Deleta um perfil de  usuario.
     * @return uma entidade de resposta generica.
     */
    @DeleteMapping(path = "/perfilUsuarios/perfilUsuario/{id}", consumes = "application/json")
    public ResponseEntity<?> deletaPerfilUsuarioId(@PathVariable("id") Long id) {

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(perfilUsuarioService.deletePerfilUsuario(id));
    }
    
}