package br.com.ifba.entity.matrizcurricular.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.entity.matrizcurricular.dto.MatrizCurricularResponseDto;
import br.com.ifba.entity.matrizcurricular.model.MatrizCurricular;

/**
 * Interface de serviço para Matriz Curricular.
 * 
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
 */
public interface IServiceMatrizCurricular {

    /**
     * Salva uma Matriz Curricular na base de dados e retorna um objeto DTO com os dados resumidos da Matriz Curricular salva.
     *
     * @param matrizCurricular - A Matriz Curricular que será salva na base de dados.
     * @return um objeto DTO com os dados resumidos da Matriz Curricular salva.
     */
    MatrizCurricularResponseDto saveMatrizCurricular(MatrizCurricular matrizCurricular);

    /**
     * Atualiza uma Matriz Curricular na base de dados e retorna um objeto DTO com os dados resumidos da Matriz Curricular atualizada.
     *
     * @param matrizCurricular - A Matriz Curricular que será atualizada na base de dados.
     * @return um objeto DTO com os dados resumidos da Matriz Curricular atualizada.
     */
    MatrizCurricularResponseDto updateMatrizCurricular(MatrizCurricular matrizCurricular);

    /**
     * Deleta uma Matriz Curricular com base no ID.
     *
     * @param id - O ID da Matriz Curricular a ser deletada.
     * @return um objeto DTO com os dados da Matriz Curricular deletada.
     */
    MatrizCurricularResponseDto deleteMatrizCurricular(UUID id);

    /**
     * Obtém uma lista de todas as Matrizes Curriculares como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as Matrizes Curriculares.
     */
    List<MatrizCurricularResponseDto> getAllMatrizCurricular();
}
