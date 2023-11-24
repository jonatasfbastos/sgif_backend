package br.com.ifba.sgif.api.entity.tecnicoadministrativo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.sgif.api.infrastructure.exception.BusinessException;
import br.com.ifba.sgif.api.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;

import br.com.ifba.sgif.api.entity.tecnicoadministrativo.dao.IDaoTecnicoAdministrativo;
import br.com.ifba.sgif.api.entity.tecnicoadministrativo.dto.TecnicoAdministrativoResponseDto;
import br.com.ifba.sgif.api.entity.tecnicoadministrativo.model.TecnicoAdministrativo;

/**
 * Service que fornece operações relacionadas a Técnico Administrativo.
 *
 * @author unknown
 * @since V1.0.1
 * @Editado por Andesson Reis
 */
@Service
public class ServiceTecnicoAdministrativo implements IServiceTecnicoAdministrativo {
    // =========================================================== //
    // ======================= [ ATRIBUTOS ] ===================== //
    // =========================================================== //

    @Autowired
    private IDaoTecnicoAdministrativo tecnicoAdministrativoDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // ========================= [ MÉTODOS ] ===================== //
    // =========================================================== //

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Salva um Técnico Administrativo na base de dados e retorna um objeto DTO com os dados resumidos do Técnico Administrativo salvo.
     *
     * @param tecnicoAdministrativo - O Técnico Administrativo que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do Técnico Administrativo salvo.
     */
    @Override
    public TecnicoAdministrativoResponseDto saveTecnicoAdministrativo(TecnicoAdministrativo tecnicoAdministrativo) {
        return objectMapperUtil.map(
                tecnicoAdministrativoDao.save(tecnicoAdministrativo),
                TecnicoAdministrativoResponseDto.class);
    }

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Atualiza um Técnico Administrativo na base de dados e retorna um objeto DTO com os dados resumidos do Técnico Administrativo atualizado.
     *
     * @param tecnicoAdministrativo - O Técnico Administrativo que será atualizado na base de dados.
     * @return um objeto DTO com os dados resumidos do Técnico Administrativo atualizado.
     */
    @Override
    public TecnicoAdministrativoResponseDto updateTecnicoAdministrativo(TecnicoAdministrativo tecnicoAdministrativo) {
        tecnicoAdministrativoDao.findById(tecnicoAdministrativo.getId())
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        return objectMapperUtil.map(
                tecnicoAdministrativoDao.save(tecnicoAdministrativo),
                TecnicoAdministrativoResponseDto.class);
    }

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Obtém uma lista de todos os Técnicos Administrativos como objetos DTO.
     *
     * @return uma lista de objetos DTO representando os Técnicos Administrativos.
     */
    @Override
    public List<TecnicoAdministrativoResponseDto> getAllTecnicoAdministrativo() {
        
        return objectMapperUtil.mapAll(
                this.tecnicoAdministrativoDao.findAll(),
                TecnicoAdministrativoResponseDto.class);
    }

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Deleta um Técnico Administrativo com base no ID.
     *
     * @param id - O ID do Técnico Administrativo a ser deletado.
     * @return um objeto DTO com os dados do Técnico Administrativo deletado.
     */
    @Override
    public TecnicoAdministrativoResponseDto deleteTecnicoAdministrativo(UUID id) {

        return this.tecnicoAdministrativoDao.findById(id)
                .map(tecnicoAdministrativo -> {
                    tecnicoAdministrativoDao.delete(tecnicoAdministrativo);
                    return objectMapperUtil.map(tecnicoAdministrativo, TecnicoAdministrativoResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }
}
