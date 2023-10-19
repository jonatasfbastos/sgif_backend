package br.com.ifba.entity.curso.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.entity.curso.dto.CursoResponseDto;
import org.springframework.stereotype.Service;

import br.com.ifba.entity.curso.model.Curso;

/**
 * @author Unknown
 * Editado por Giovane Neves
 * Desde V1.0.1
 */
@Service
public interface ICursoService {

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     *
     * Lista todos os cursos cadastrados na base de dados.
     * @return uma lista com todos os cursos da base de dados.
     */
    List<CursoResponseDto> listarCursos();

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     *
     * Busca o curso cadastrado na base de dados atrelado ao ID
     * passado por parâmetro.
     * @param id O ID do curso a ser buscado.
     * @return o curso atrelado ao ID passado por parâmetro.
     */
    CursoResponseDto encontrarCursoPorId(UUID id);

    Curso salvarCurso(Curso curso);

    //atualiza Curso
    Curso atualizarCurso(Curso curso);

    //deleta Curso
    void deletarCurso(Curso curso);

}
