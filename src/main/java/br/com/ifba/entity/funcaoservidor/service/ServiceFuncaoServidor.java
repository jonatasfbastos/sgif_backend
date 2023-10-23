package br.com.ifba.entity.funcaoservidor.service;

import br.com.ifba.entity.funcaoservidor.dao.IDaoFuncaoServidor;
import br.com.ifba.entity.funcaoservidor.dto.FuncaoServidorResponseDto;
import br.com.ifba.entity.funcaoservidor.model.FuncaoServidor;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.entity.tecnicoadministrativo.dao.IDaoTecnicoAdministrativo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Service que fornece operações relacionadas a Função de Servidor.
 *
 * @author Gusd
 * @since V1.0.1
 * @Editado por Andesson Reis
 */
@Service
public class ServiceFuncaoServidor implements IServiceFuncaoServidor {

    // =========================================================== //
    // =============== [ ATRIBUTOS ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoFuncaoServidor funcaoServidorDao;

    @Autowired
    private IDaoTecnicoAdministrativo daoTecnicoAdministrativo;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ MÉTODOS ] ================== //
    // =========================================================== //



    /**
     * Salva uma Função de Servidor na base de dados e retorna um objeto DTO com os dados resumidos da Função de Servidor salva.
     *
     * @param funcaoServidor - A Função de Servidor que será salva na base de dados.
     * @return um objeto DTO com os dados resumidos da Função de Servidor salva.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public FuncaoServidorResponseDto saveFuncaoServidor(FuncaoServidor funcaoServidor) {
        
        return objectMapperUtil.map(
                funcaoServidorDao.save(funcaoServidor),
                FuncaoServidorResponseDto.class);
    }
    /**
     * Deleta uma Função de Servidor com base no ID.
     *
     * @param id - O ID da Função de Servidor a ser deletada.
     * @return um objeto DTO com os dados da Função de Servidor deletada.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public FuncaoServidorResponseDto deleteFuncaoServidor(UUID id) {

        return this.funcaoServidorDao.findById(id)
                .map(funcaoServidor -> {
                    funcaoServidorDao.delete(funcaoServidor);
                    return objectMapperUtil.map(funcaoServidor, FuncaoServidorResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * Obtém uma lista de todas as Funções de Servidor como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as Funções de Servidor.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public List<FuncaoServidorResponseDto> getAllFuncaoServidor() {

        return objectMapperUtil.mapAll(
                this.funcaoServidorDao.findAll(),
                FuncaoServidorResponseDto.class);
    }

    /**
     * Atualiza uma Função de Servidor na base de dados e retorna um objeto DTO com os dados resumidos da Função de Servidor atualizada.
     *
     * @param funcaoServidor - A Função de Servidor que será atualizada na base de dados.
     * @return um objeto DTO com os dados resumidos da Função de Servidor atualizada.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public FuncaoServidorResponseDto updateFuncaoServidor(FuncaoServidor funcaoServidor) {

        funcaoServidorDao.findById(funcaoServidor.getId())
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        return objectMapperUtil.map(
                funcaoServidorDao.save(funcaoServidor),
                FuncaoServidorResponseDto.class);
    }

}