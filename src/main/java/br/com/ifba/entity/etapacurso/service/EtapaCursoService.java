package br.com.ifba.entity.etapacurso.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.ifba.entity.etapacurso.dao.IEtapaCursoDao;
import br.com.ifba.entity.etapacurso.dto.EtapaCursoResponseDto;
import br.com.ifba.entity.etapacurso.model.EtapaCurso;
import br.com.ifba.entity.questao.dto.QuestaoResponseDto;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.entity.turma.dao.ITurmaDao;


/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Service
public class EtapaCursoService implements IEtapaCursoService {
    // =========================================================== //
    // =============== [       ATRIBUTOS        ] ================ //
    // =========================================================== //

    @Autowired
    private IEtapaCursoDao etapaCursoDao;
    @Autowired
    private ITurmaDao turmaDao;
    @Autowired
    private ObjectMapperUtil objectMapperUtil;


    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    /**
     * Lista todas as etapas de curso cadastradas na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return uma lista de DTO com dados de todas as etapas de curso da base de dados.
     */
    @Override
    public List<EtapaCursoResponseDto> listarEtapasCurso() {


        return this.objectMapperUtil.mapAll(
                this.etapaCursoDao.findAll(),
                EtapaCursoResponseDto.class
        );

    }

    /**
     * Busca uma etapa de curso na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da etapa de curso a ser buscada.
     * @return DTO com dados da etapa de curso atrelada ao ID passado por parâmetro.
     */
    @Override
    public EtapaCursoResponseDto encontrarEtapaCursoPorId(UUID id) {

        return this.etapaCursoDao.findById(id)
                .map(ec -> this.objectMapperUtil.map(ec, EtapaCursoResponseDto.class))
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );


    }

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
    @Override
    public List<EtapaCursoResponseDto> encontrarEtapaCursoPorNome(String nome) {

        return this.etapaCursoDao.findByNome(nome)
                .stream()
                .map(ec -> this.objectMapperUtil.map(ec, EtapaCursoResponseDto.class))
                .collect(Collectors.toList());

    }

    /**
     * Salva uma etapa de curso na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param etapaCurso A etapa de curso a ser salva na base de dados.
     * @return DTO com dados da etapa de curso salva.
     */
    @Override
    public EtapaCursoResponseDto salvarEtapaCurso(EtapaCurso etapaCurso) {

        // TODO: Verificar regra de negócios de validação

        return this.objectMapperUtil.map(
                etapaCurso,
                EtapaCursoResponseDto.class
        );

    }

    /**
     * Atualiza uma etapa de curso existente na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param etapaCurso A estapa de curso a ser atualizada.
     * @return DTO com dados da etapa de curso atualizada.
     */
    @Override
    public EtapaCursoResponseDto atualizarEtapaCurso(EtapaCurso etapaCurso) {

        return this.etapaCursoDao.findById(etapaCurso.getId())
                .map(ec -> this.objectMapperUtil.map(ec, EtapaCursoResponseDto.class))
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );

    }


    /**
     * Deleta uma etapa de curso na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da etapa de curso a ser deletada.
     * @return DTO com dados da etapa de curso deletada.
     */
    @Override
    public EtapaCursoResponseDto deletarEtapaCursoPorId(UUID id) {

        return this.etapaCursoDao.findById(id)
                .map(ec -> {
                    this.etapaCursoDao.delete(ec);
                    return this.objectMapperUtil.map(ec, EtapaCursoResponseDto.class);
                })
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );

    }



}
