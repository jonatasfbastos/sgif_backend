package br.com.ifba.controller.v1;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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

import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.funcaotecnicoadministrativo.dto.FuncaoTecnicoAdministrativoRequestDto;
import br.com.ifba.entity.funcaotecnicoadministrativo.model.FuncaoTecnicoAdministrativo;
import br.com.ifba.entity.funcaotecnicoadministrativo.service.IServiceFuncaoTecnicoAdministrativo;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar funções de técnico administrativo.
 *
 * @author Andesson Reis
 * Editado por Giovane Neves
 * @since V1.0.1
 *
 * Veja também: {@link br.com.ifba.entity.funcao_tecnico_administrativo.model.FuncaoTecnicoAdministrativo}
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class FuncaoTecnicoAdministrativoController {

    @Autowired
    IServiceFuncaoTecnicoAdministrativo funcaoTecnicoAdministrativoService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;


    /**
     * Obtém a lista de todas as funções de técnico administrativo.
     *
     * @return Uma lista de funções de técnico administrativo ou uma resposta de erro em caso de falha.
     */
    @GetMapping(path = "/funcoes-tecnico-administrativo/funcao-tecnico-administrativo", produces = "application/json")
    public ResponseEntity<?> listarFuncoesTecnicoAdministrativo() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(funcaoTecnicoAdministrativoService.getAllFuncoesTecnicoAdm());
    }

    /**
     * Salva uma função de técnico administrativo.
     *
     * @return Uma entidade de resposta genérica.
     */
    @PostMapping(path = "/funcoes-tecnico-administrativo/funcao-tecnico-administrativo", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> salvarFuncaoTecnicoAdministrativo(@Valid @RequestBody FuncaoTecnicoAdministrativoRequestDto funcaoTecnicoAdmDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(funcaoTecnicoAdministrativoService.saveFuncaoTecnicoAdm(objectMapperUtil.map(funcaoTecnicoAdmDto, FuncaoTecnicoAdministrativo.class)));
    }

    /**
     * Deleta uma função de técnico administrativo com base no seu ID.
     *
     * @return Uma entidade de resposta genérica.
     */
    @DeleteMapping(path = "/funcoes-tecnico-administrativo/funcao-tecnico-administrativo/{id}", produces = "application/json")
    public ResponseEntity<?> deletarFuncaoTecnicoAdministrativoPorID(@Valid @PathVariable("id") @NotNull UUID id) {

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(funcaoTecnicoAdministrativoService.deleteFuncaoTecnicoAdm(id));
    }
}