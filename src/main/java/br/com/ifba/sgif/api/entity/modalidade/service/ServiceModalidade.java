package br.com.ifba.sgif.api.entity.modalidade.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.modalidade.dao.IDaoModalidade;
import br.com.ifba.sgif.api.entity.modalidade.dto.ModalidadeResponseDto;
import br.com.ifba.sgif.api.entity.modalidade.model.Modalidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.sgif.api.infrastructure.exception.BusinessException;
import br.com.ifba.sgif.api.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;
/**
 * Service que fornece operações relacionadas a Modalidade.
 *
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
 */
@Service
public class ServiceModalidade implements IServiceModalidade{

    // =========================================================== //
    // ======================== [ ATRIBUTOS ] ==================== //
    // =========================================================== //

   @Autowired
    private IDaoModalidade modalidadeDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // ======================== [ MÉTODOS ] ====================== //
    // =========================================================== //

    /**
     * Salva uma Modalidade na base de dados e retorna um objeto DTO com os dados resumidos da Modalidade salva.
     *
     * @param modalidade - A Modalidade que será salva na base de dados.
     * @return um objeto DTO com os dados resumidos da Modalidade salva.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public ModalidadeResponseDto saveModalidade(Modalidade modalidade) {

        return objectMapperUtil.map(
                modalidadeDao.save(modalidade),
                ModalidadeResponseDto.class);
    }

    /**
     * Atualiza uma Modalidade na base de dados e retorna um objeto DTO com os dados resumidos da Modalidade atualizada.
     *
     * @param modalidade - A Modalidade que será atualizada na base de dados.
     * @return um objeto DTO com os dados resumidos da Modalidade atualizada.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public ModalidadeResponseDto updateModalidade(Modalidade modalidade) {

        modalidadeDao.findById(modalidade.getId())
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        return objectMapperUtil.map(
                modalidadeDao.save(modalidade),
                ModalidadeResponseDto.class);
    }

    /**
     * Deleta uma Modalidade com base no ID.
     *
     * @param id - O ID da Modalidade a ser deletada.
     * @return um objeto DTO com os dados da Modalidade deletada.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public ModalidadeResponseDto deleteModalidade(UUID id) {

        return this.modalidadeDao.findById(id)
                .map(modalidade -> {
                    modalidadeDao.delete(modalidade);
                    return objectMapperUtil.map(modalidade, ModalidadeResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * Obtém uma lista de todas as Modalidades como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as Modalidades.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public List<ModalidadeResponseDto> getAllModalidade() {

        return objectMapperUtil.mapAll(
                this.modalidadeDao.findAll(),
                ModalidadeResponseDto.class);
    }
}