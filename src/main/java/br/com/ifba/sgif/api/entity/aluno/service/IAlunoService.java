package br.com.ifba.sgif.api.entity.aluno.service;

import java.util.List;

import br.com.ifba.sgif.api.entity.aluno.dto.AlunoResponseDto;
import br.com.ifba.sgif.api.entity.aluno.model.Aluno;

/**
 * @author Unknown
 * Editado por Giovane Neves
 * @since Desde V1.0.1
 */
public interface IAlunoService {

    // =========================================================== //
    // =============== [ ASSINATURAS DE MÉTODOS ] ================ //
    // =========================================================== //

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * Lista todos os alunos presentes na base de dados.
     * @return uma lista com todos os alunos da base de dados, ou nulo caso não existe nenhum.
     */
    List<AlunoResponseDto> listarAlunos();

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * Salva um aluno na base de ddados.
     * @param aluno O Aluno que será salvo na base de dados.
     * @return um objeto DTO com os dados do aluno salvo na base de dados,
     * caso a operação ocorra com sucesso.
     *
     */
    AlunoResponseDto salvarAluno(Aluno aluno);

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * Atualiza os dados de uma aluno existente na base de dados.
     * @param aluno O Aluno que terá os seus dados atualizados.
     * @return os dados atualizados do aluno.
     */
    AlunoResponseDto atualizarAluno(Aluno aluno);

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * Deleta um aluno da base de dados.
     * @param id O ID do aluno que será deletado da base de dados.
     */
    AlunoResponseDto deletarAlunoPorId(Long id);


}
