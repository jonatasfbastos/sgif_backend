package br.com.ifba.sgif.api.controller.v1;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.ifba.sgif.api.controller.v1.util.ResultError;
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

import br.com.ifba.sgif.api.entity.servidor.dto.ServidorRequestDto;
import br.com.ifba.sgif.api.entity.servidor.model.Servidor;
import br.com.ifba.sgif.api.entity.servidor.service.IServiceServidor;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar servidores.
 *
 * @author Andesson Reis
 * Editado por Giovane Neves
 * @since V1.0.1
 *
 * Veja também: {@link Servidor}
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class ServidorController {

    // =========================================================== //
    // =============== [ ATRIBUTOS ] ============================= //
    // =========================================================== //
    @Autowired
    IServiceServidor servidorService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ ENDPOINTS ] ============================= //
    // =========================================================== //

    /**
     * Obtém a lista de todos os servidores.
     *
     * @return Uma lista de servidores ou uma resposta de erro em caso de falha.
     */
    @GetMapping(path = "/servidores", produces = "application/json")
    public ResponseEntity<?> listarServidores() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(servidorService.getAllServidor());
    }

    /**
     * Salva um servidor.
     *
     * @return Uma entidade de resposta genérica.
     */
    @PostMapping(path = "/servidores/servidor", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> salvarServidor(@Valid @RequestBody ServidorRequestDto servidorDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(servidorService.saveServidor(objectMapperUtil.map(servidorDto, Servidor.class)));
    }

    /**
     * Deleta um servidor com base no seu ID.
     *
     * @return Uma entidade de resposta genérica.
     */
    @DeleteMapping(path = "/servidores/servidor/{id}", produces = "application/json")
    public ResponseEntity<?> deletarServidorPorID(@Valid @PathVariable("id") @NotNull Long id) {

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(servidorService.deleteServidor(id));
    }

}
