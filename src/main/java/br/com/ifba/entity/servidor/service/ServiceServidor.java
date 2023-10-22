package br.com.ifba.entity.servidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.entity.formulario.dto.FormularioSimpleResponseDto;
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
                        BusinessExceptionMessage.ATTRIBUTE_VALUE_ALREADY_EXISTS.getMensagemValorJaExiste("título"))
                );
    }

    @Override
    public Servidor updateServidor(Servidor servidor) {
        if(servidor == null) {
            throw new BusinessException(Servidor_NULL);
        }
        if(servidorDao.findById(servidor.getId()) == null) {
            throw new BusinessException(Servidor_NAO_EXISTE);
        }
        return servidorDao.save(servidor);
    }


    @Override
    public void deleteServidor(Servidor servidor) {
        if (servidor == null) {
            throw new BusinessException(Servidor_NULL);
        } 
        if(servidorDao.existsById(servidor.getId()) == false) {
            throw new BusinessException(Servidor_NAO_EXISTE);
        }
      servidorDao.delete(servidor);
    
    }

    @Override
    public List<Servidor> getAllServidor() {
        return this.servidorDao.findAll();
    }

}
