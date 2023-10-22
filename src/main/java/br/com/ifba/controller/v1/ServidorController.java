package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.servidor.service.IServiceServidor;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar servidores.
 *
 * @author Andesson Reis
 * @since V1.0.1
 *
 * Veja também: {@link br.com.ifba.entity.servidor.model.Servidor}
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
    @GetMapping(path = "/servidores", consumes = "application/json")
    public ResponseEntity<?> getServidores() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(servidorService.getAllServidor());
    }
}
