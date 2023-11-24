package br.com.ifba.sgif.api.entity.curso.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.curso.dto.CursoResponseDto;
import org.springframework.stereotype.Service;

import br.com.ifba.sgif.api.entity.curso.model.Curso;

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
     * <p>
     * Lista todos os cursos cadastrados na base de dados.
     * @return uma lista com todos os cursos da base de dados.
     */
    List<CursoResponseDto> listarCursos();

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     * <p>
     * Busca o curso cadastrado na base de dados atrelado ao ID
     * passado por parâmetro.
     * @param id O ID do curso a ser buscado.
     * @return o curso atrelado ao ID passado por parâmetro.
     */
    CursoResponseDto encontrarCursoPorId(UUID id);

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     * <p>
     * Cadastra um curso na base de dados.
     * @param curso O curso a ser cadastrado.
     * @return dados básicos do curso cadastrado.
     */
    CursoResponseDto salvarCurso(Curso curso);

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     * <p>
     * Atualiza um curso existente na base de dados.
     * @param curso O curso a ser atualizado.
     * @return dados básicos do curso atualizado.
     */
    CursoResponseDto atualizarCurso(Curso curso);

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     * <p>
     * Deleta o formulário atrelado ao ID passado por parâmetro.
     * @param id O ID do formulário a ser deletado.
     * @return dados básicos do formulário deletado.
     */
    CursoResponseDto deletarCursoPorId(UUID id);

}
