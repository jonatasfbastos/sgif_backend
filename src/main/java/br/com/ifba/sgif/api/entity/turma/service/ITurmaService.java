package br.com.ifba.sgif.api.entity.turma.service;

import java.util.List;

import br.com.ifba.sgif.api.entity.turma.dto.TurmaResponseDto;
import br.com.ifba.sgif.api.entity.turma.model.Turma;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
public interface ITurmaService {

    // =========================================================== //
    // =============== [ ASSINATURAS DE MÉTODOS ] ================ //
    // =========================================================== //

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * @return uma lista com todas as turmas da base de dados, ou nulo, caso não exista nenhuma.
     */
    List<TurmaResponseDto> listarTurmas();

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * @param turma A turma que será salva na base de dados.
     * @return um objeto DTO com os dados da turma salva na base de dados,
     * caso a operação ocorra com sucesso.
     */
    TurmaResponseDto salvarTurma(Turma turma);

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * @param turma A turma que terá os seus dados atualizados.
     * @return um DTO com os dados atualizados da turma.
     */
    TurmaResponseDto atualizarTurma(Turma turma);

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * @param id O ID da turma que será deletado da base de dados.
     * @return um DTO com os dados da turma deletada da base de dados.
     */
    TurmaResponseDto deletarTurmaPorId(Long id);


}
