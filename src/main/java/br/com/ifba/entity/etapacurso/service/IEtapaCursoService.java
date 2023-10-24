package br.com.ifba.entity.etapacurso.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.entity.etapacurso.dto.EtapaCursoResponseDto;
import br.com.ifba.entity.etapacurso.model.EtapaCurso;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
public interface IEtapaCursoService {

     // =========================================================== //
     // =============== [ ASSINATURAS DE MÉTODOS ] ================ //
     // =========================================================== //


     /**
      * Lista todas as etapas de curso cadastradas na base de dados.
      *
      * @author Giovane Neves
      * @since Desde V1.0.1
      * @return uma lista de DTO com dados de todas as etapas de curso da base de dados.
      */
     List<EtapaCursoResponseDto> listarEtapasCurso();

     /**
      * Busca uma etapa de curso na base de dados com base no ID passado por parâmetro.
      *
      * @author Giovane Neves
      * @since Desde V1.0.1
      * @param id O ID da etapa de curso a ser buscada.
      * @return DTO com dados da etapa de curso atrelada ao ID passado por parâmetro.
      */
     EtapaCursoResponseDto encontrarEtapaCursoPorId(UUID id);

     /**
      * Busca etapa de curso na base de dados com base no nome
      * passado por parâmetro.
      *
      * @author Giovane Neves
      * @since Desde V1.0.1
      * @param nome O nome das etapas de curso a serem buscadas.
      * @return Lista de DTO com dados das etapas de curso que possuem o nome
      * passado por parâmetro.
      */
     List<EtapaCursoResponseDto> encontrarEtapaCursoPorNome(String nome);


     /**
      * Salva uma etapa de curso na base de dados.
      *
      * @author Giovane Neves
      * @since Desde V1.0.1
      * @param etapaCurso A etapa de curso a ser salva na base de dados.
      * @return DTO com dados da etapa de curso salva.
      */
     EtapaCursoResponseDto salvarEtapaCurso(EtapaCurso etapaCurso);

     /**
      * Atualiza uma etapa de curso existente na base de dados.
      *
      * @author Giovane Neves
      * @since Desde V1.0.1
      * @param etapaCurso A estapa de curso a ser atualizada.
      * @return DTO com dados da etapa de curso atualizada.
      */
     EtapaCursoResponseDto atualizarEtapaCurso(EtapaCurso etapaCurso);

     /**
      * Deleta uma etapa de curso na base de dados com base no ID passado por parâmetro.
      *
      * @author Giovane Neves
      * @since Desde V1.0.1
      * @param id O ID da etapa de curso a ser deletada.
      * @return DTO com dados da etapa de curso deletada.
      */
     EtapaCursoResponseDto deletarEtapaCursoPorId(UUID id);
}
