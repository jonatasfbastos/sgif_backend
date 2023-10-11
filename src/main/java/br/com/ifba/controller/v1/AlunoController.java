package br.com.ifba.controller;

import br.com.ifba.entity.aluno.model.Aluno;
import br.com.ifba.entity.aluno.service.IServiceAluno;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/apif/v1")
public class AlunoController {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //
    Gson gson = new Gson();

    @Autowired
    private IServiceAluno serviceAluno;

    // =========================================================== //
    // =============== [         ENDPOINTS      ] ================ //
    // =========================================================== //

    @GetMapping(path = "/alunos")
    public ResponseEntity<?> listarAlunos() {
        return ResponseEntity.status(HttpStatus.OK).body(serviceAluno.listarAlunos());
    }

    @PostMapping(path = "/alunos/aluno")
    public ResponseEntity<?> salvarAluno(@RequestBody String aluno1) {

        Aluno aluno = (Aluno) gson.fromJson(aluno1, Aluno.class);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(serviceAluno.salvarAluno(aluno));

    }

    @DeleteMapping(path = "/alunos/aluno/{id}")
    public boolean deletarAluno(@PathVariable("id") Long id) {
        Aluno aluno = new Aluno();
        aluno.setId(id);
        serviceAluno.deletarAluno(aluno);
        return true;
    }
}
