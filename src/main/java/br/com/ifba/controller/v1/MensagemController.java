package br.com.ifba.controller.v1;

import java.util.UUID;

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
import br.com.ifba.entity.mensagem.dto.MensagemRequestDto;
import br.com.ifba.entity.mensagem.model.Mensagem;
import br.com.ifba.entity.mensagem.service.IServiceMensagem;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
/**
 * @author Andesson reis
 * @since V1.0.1
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class MensagemController {
    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    IServiceMensagem mensagemService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [         ENDPOINTS      ] ================ //
    // =========================================================== //

    /**
     * Obtém a lista de todas as mensagens.
     *
     * @return Uma lista de mensagens ou uma resposta de erro em caso de falha.
     */
    @GetMapping(consumes = "application/json")
    public ResponseEntity<?> getMensagens() {
        return ResponseEntity.status(HttpStatus.OK).body(mensagemService.getAllMensagem());
    }

    /**
     * Atualiza uma mensagem.
     *
     * @return Uma entidade de resposta genérica.
     */
    @PutMapping(consumes = "application/json")
    public ResponseEntity<?> atualizarMensagem(@Valid @RequestBody MensagemRequestDto mensagemDto, BindingResult result) {
        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(mensagemService.updateMensagem(objectMapperUtil.map(mensagemDto, Mensagem.class)));
    }

    /**
     * Salva uma mensagem.
     *
     * @return Uma entidade de resposta genérica.
     */
    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> salvarMensagem(@Valid @RequestBody MensagemRequestDto mensagemDto, BindingResult result) {
        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(mensagemService.saveMensagem(objectMapperUtil.map(mensagemDto, Mensagem.class)));
    }

    /**
     * Deleta uma mensagem com base no seu ID.
     *
     * @return Uma entidade de resposta genérica.
     */
    @DeleteMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<?> deletarMensagemPorID(@Valid @PathVariable("id") UUID id) {
        
        return ResponseEntity.status(HttpStatus.ACCEPTED)
            .body(mensagemService.deleteMensagem(id));
    }
}
