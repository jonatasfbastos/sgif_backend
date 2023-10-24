package br.com.ifba.entity.questao.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.ifba.entity.questao.dto.QuestaoResponseDto;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.entity.questao.dao.IQuestaoDao;
import br.com.ifba.entity.questao.model.Questao;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Service
public class QuestaoService implements IQuestaoService {

    // =========================================================== //
    // =============== [       ATRIBUTOS        ] ================ //
    // =========================================================== //
    
    @Autowired
     private IQuestaoDao questaoDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    /**
     * Lista todas as questões cadastradas na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return uma lista de DTO com dados de todas as questões da base de dados.
     */
    @Override
    public List<QuestaoResponseDto> listarQuestoes() {

        return this.objectMapperUtil.mapAll(
                this.questaoDao.findAll(),
                QuestaoResponseDto.class
        );

    }

    /**
     * Busca uma questão na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da questão a ser buscada.
     * @return DTO com dados da  questão atrelada ao ID passado por parâmetro.
     */
     @Override
     public QuestaoResponseDto encontrarQuestaoPorId(UUID id) {

          return this.questaoDao.findById(id)
                  .map(q -> this.objectMapperUtil.map(q, QuestaoResponseDto.class))
                  .orElseThrow(
                          () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                  );

     }

    /**
     * Busca questões na base de dados com base no enunciado passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param enunciado O enunciado das questões a serem buscadas.
     * @return Lista de DTO com dados das questões que possuem o enunciado passado por parâmetro.
     */
    @Override
    public List<QuestaoResponseDto> encontrarQuestaoPorEnunciado(String enunciado) {

        // TODO: Verificar 'findByEnunciado' no repositório

         return this.questaoDao.findByEnunciado(enunciado)
                 .stream()
                 .map(q -> this.objectMapperUtil.map(q, QuestaoResponseDto.class))
                 .collect(Collectors.toList());

    }

    /**
     * Salva uma questão na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param questao A questão a ser salva na base de dados.
     * @return DTO com dados da questão salva.
     */
    @Override
    public QuestaoResponseDto salvarQuestao(Questao questao) {

         return Optional.of(questao)
                 .filter(q -> this.questaoDao.existsByEnunciado(q.getEnunciado()))
                 .map(q -> this.objectMapperUtil.map(q, QuestaoResponseDto.class))
                 .orElseThrow(
                         () -> new BusinessException(BusinessExceptionMessage.ATTRIBUTE_VALUE_ALREADY_EXISTS.getMensagemValorJaExiste("enunciado"))
                 );
    }

    /**
     * Atualiza uma questão existente na base de dados.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param questao A questão a ser atualizada.
     * @return DTO com dados da questão atualizada.
     */
    @Override
    public QuestaoResponseDto atualizarQuestao(Questao questao) {

        return this.questaoDao.findById(questao.getId())
                .map(q -> this.objectMapperUtil.map(q, QuestaoResponseDto.class))
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );
    }

    /**
     * Deleta uma questão na base de dados com base no ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param id O ID da questão a ser deletada.
     * @return DTO com dados da questão deletada.
     */
    @Transactional
    @Override
    public QuestaoResponseDto deletarQuestaoPorId(UUID id) {

        return this.questaoDao.findById(id)
                .map(q -> {
                    this.questaoDao.delete(q);
                    return this.objectMapperUtil.map(q, QuestaoResponseDto.class);
                })
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );
    }



}
