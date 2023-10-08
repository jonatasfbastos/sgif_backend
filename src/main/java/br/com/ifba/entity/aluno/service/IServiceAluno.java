package br.com.ifba.entity.aluno.service;

import java.util.List;

import br.com.ifba.entity.aluno.dto.AlunoResponseDto;
import br.com.ifba.entity.aluno.model.Aluno;

public interface IServiceAluno {

    // =========================================================== //
    // =============== [ ASSINATURAS DE MÉTODOS ] ================ //
    // =========================================================== //

    /**
     *
     * Salva um aluno na base de ddados.
     *
     * @param aluno - O Aluno que será salvo na base de dados.
     * @return um objeto DTO com os dados do aluno salvo na base de dados,
     * caso a operação ocorra com sucesso.
     *
     */
    AlunoResponseDto salvarAluno(Aluno aluno);

    /**
     *
     * Atualiza os dados de uma aluno existente na base de dados.
     *
     * @param aluno - O Aluno que terá os seus dados atualizados.
     * @return os dados atualizados do aluno.
     *
     */
    Aluno atualizarAluno(Aluno aluno);

    /**
     *
     * Deleta um aluno da base de dados.
     *
     * @param aluno - O Aluno que será deletado da base de dados.
     *
     */
    void deletarAluno(Aluno aluno);

    /**
     *
     * Lista todos os alunos presentes na base de dados.
     *
     * @return uma lista com todos os alunos da base de dados, ou nulo caso não existe nenhum.
     */
    List<Aluno> listarAlunos();

    /**
     *
     * AVISO: Temporariamente desabilitada enquanto não é entendida a sua utilidade.
     *
     */
    List<Aluno> findByStatusAlunoId(Long id);

}
