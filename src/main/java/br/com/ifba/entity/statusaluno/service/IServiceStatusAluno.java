package br.com.ifba.entity.statusaluno.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.entity.statusaluno.dto.StatusAlunoResponseDto;
import br.com.ifba.entity.statusaluno.model.StatusAluno;

/**
 * Interface de serviço para Status do Aluno.
 *
 * @author Ellen Cristina
 * Editado por Andesson Reis
 * @since Desde V1.0.1
 */
public interface IServiceStatusAluno {

    /**
     * Salva o Status do Aluno na base de dados e retorna um objeto DTO com os dados resumidos do Status do Aluno salvo.
     *
     * @param status - O Status do Aluno que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do Status do Aluno salvo.
     */
    StatusAlunoResponseDto saveStatus(StatusAluno status);

    /**
     * Atualiza o Status do Aluno na base de dados e retorna um objeto DTO com os dados resumidos do Status do Aluno atualizado.
     *
     * @param status - O Status do Aluno que será atualizado na base de dados.
     * @return um objeto DTO com os dados resumidos do Status do Aluno atualizado.
     */
    StatusAlunoResponseDto updateStatus(StatusAluno status);

    /**
     * Deleta o Status do Aluno com base no ID.
     *
     * @param id - O ID do Status do Aluno a ser deletado.
     * @return um objeto DTO com os dados do Status do Aluno deletado.
     */
    StatusAlunoResponseDto deleteStatus(UUID id);

    /**
     * Obtém uma lista de todos os Status dos Alunos como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os Status dos Alunos.
     */
    List<StatusAlunoResponseDto> getAllstatus();
}
