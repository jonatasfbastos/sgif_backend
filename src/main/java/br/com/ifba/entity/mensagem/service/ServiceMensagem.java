package br.com.ifba.entity.mensagem.service;

import br.com.ifba.entity.mensagem.model.Mensagem;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.entity.mensagem.dao.IDaoMensagem;
import br.com.ifba.entity.mensagem.dto.MensagemResponseDto;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service que fornece operações relacionadas a Mensagem.
 *
 * @author felipe
 * @since V1.0.1
 * Editado por Andesson Reis
 */
@Service
public class ServiceMensagem implements IServiceMensagem{
    // =========================================================== //
    // =============== [ ATRIBUTOS ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoMensagem mensagemDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ MÉTODOS ] ================== //
    // =========================================================== //
    

    /**
     * Salva uma Mensagem na base de dados e retorna um objeto DTO com os dados resumidos da Mensagem salva.
     *
     * @param mensagem - A Mensagem que será salva na base de dados.
     * @return um objeto DTO com os dados resumidos da Mensagem salva.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public MensagemResponseDto saveMensagem(Mensagem mensagem) {

        return objectMapperUtil.map(
                mensagemDao.save(mensagem),
                MensagemResponseDto.class);
    }

    /**
     * Atualiza uma Mensagem na base de dados e retorna um objeto DTO com os dados resumidos da Mensagem atualizada.
     *
     * @param mensagem - A Mensagem que será atualizada na base de dados.
     * @return um objeto DTO com os dados resumidos da Mensagem atualizada.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public MensagemResponseDto updateMensagem(Mensagem mensagem) {

        mensagemDao.findById(mensagem.getId())
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        return objectMapperUtil.map(
                mensagemDao.save(mensagem),
                MensagemResponseDto.class);
    }

    /**
     * Deleta uma Mensagem com base no ID.
     *
     * @param id - O ID da Mensagem a ser deletada.
     * @return um objeto DTO com os dados da Mensagem deletada.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public MensagemResponseDto deleteMensagem(UUID id) {

        return this.mensagemDao.findById(id)
                .map(mensagem -> {
                    mensagemDao.delete(mensagem);
                    return objectMapperUtil.map(mensagem, MensagemResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * Obtém uma lista de todas as Mensagens como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as Mensagens.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public List<MensagemResponseDto> getAllMensagem() {
        
        return objectMapperUtil.mapAll(
                this.mensagemDao.findAll(),
                MensagemResponseDto.class);
    }
}


