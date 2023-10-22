package br.com.ifba.controller.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.setor.dto.SetorRequestDto;
import br.com.ifba.entity.setor.model.Setor;
import br.com.ifba.entity.setor.service.IServiceSetor;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar setores.
 *
 * @author Andesson Reis
 * @since V1.0.1
 *
 * Veja também: {@link br.com.ifba.entity.setor.model.Setor}
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class SetorController {

    // =========================================================== //
    // =============== [ ATRIBUTOS ] ============================= //
    // =========================================================== //

    @Autowired
    IServiceSetor setorService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ ENDPOINTS ] ============================= //
    // =========================================================== //


    /**
     * Obtém a lista de todos os setores.
     *
     * @return Uma lista de setores ou uma resposta de erro em caso de falha.
     */
    @GetMapping(path = "/setores", consumes = "application/json")
    public ResponseEntity<?> getSetores() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(setorService.getAllSetor());
    }

    /**
     * Atualiza um setor.
     *
     * @return Uma entidade de resposta genérica.
     */
    @PutMapping(path = "/setores/setor", consumes = "application/json")
    public ResponseEntity<?> atualizarSetor(@Valid @RequestBody SetorRequestDto setorDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(setorService.updateSetor(objectMapperUtil.map(setorDto, Setor.class)));
    }
}
