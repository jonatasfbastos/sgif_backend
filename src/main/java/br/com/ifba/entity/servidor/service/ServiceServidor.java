package br.com.ifba.entity.servidor.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.entity.servidor.dao.IDaoServidor;
import br.com.ifba.entity.servidor.dto.ServidorResponseDto;
import br.com.ifba.entity.servidor.model.Servidor;

/**
 * Service que fornece operações relacionadas a Servidor.
 *
 * @author unknown
 * @since V1.0.1
 * @Editado por Andesson Reis
 */

@Service
public class ServiceServidor implements IServiceServidor{

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private ObjectMapperUtil objectMapperUtil;
    
   @Autowired
    private IDaoServidor servidorDao;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    /**
     * Salva um Servidor na base de dados e retorna um objeto DTO com os dados resumidos do Servidor salvo.
     *
     * @param servidor - O Servidor que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do Servidor salvo.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public ServidorResponseDto saveServidor(Servidor servidor) {

        return Optional.of(servidor)
                .filter(serv -> !this.servidorDao.existsBySiape(serv.getSiape()))
                .map(serv -> objectMapperUtil.map(this.servidorDao.save(serv), ServidorResponseDto.class))
                .orElseThrow(() -> new BusinessException(
                        BusinessExceptionMessage.ATTRIBUTE_VALUE_ALREADY_EXISTS.getMensagemValorJaExiste("siape"))
                );
    }

    /**
     * Atualiza um Servidor na base de dados e retorna um objeto DTO com os dados resumidos do Servidor atualizado.
     *
     * @param servidor - O Servidor que será atualizado na base de dados.
     * @return um objeto DTO com os dados resumidos do Servidor atualizado.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public ServidorResponseDto updateServidor(Servidor servidor) {
            
        return Optional.of(servidor)
                    .filter(serv -> !this.servidorDao.existsBySiape(serv.getSiape()))
                    .map(serv -> objectMapperUtil.map(this.servidorDao.save(serv), ServidorResponseDto.class))
                    .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );

    }

    /**
     * Deleta um Servidor com base no ID.
     *
     * @param id - O ID do Servidor a ser deletado.
     * @return um objeto DTO com os dados do Servidor deletado.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public ServidorResponseDto deleteServidor(UUID id) {

        return this.servidorDao.findById(id)
                .map(servidor -> {
                    servidorDao.delete(servidor);
                    return objectMapperUtil.map(servidor, ServidorResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * Obtém uma lista de todos os Servidores como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os Servidores.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public List<ServidorResponseDto> getAllServidor() {

        return objectMapperUtil.mapAll(
                this.servidorDao.findAll(),
                ServidorResponseDto.class);
    }
}
