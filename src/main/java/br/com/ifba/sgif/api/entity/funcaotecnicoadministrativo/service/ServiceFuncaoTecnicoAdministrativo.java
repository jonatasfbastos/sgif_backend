package br.com.ifba.sgif.api.entity.funcaotecnicoadministrativo.service;

import br.com.ifba.sgif.api.entity.funcaotecnicoadministrativo.dao.IDaoFuncaoTecnicoAdministrativo;
import br.com.ifba.sgif.api.entity.funcaotecnicoadministrativo.dto.FuncaoTecnicoAdministrativoResponseDto;
import br.com.ifba.sgif.api.entity.funcaotecnicoadministrativo.model.FuncaoTecnicoAdministrativo;
import br.com.ifba.sgif.api.infrastructure.exception.BusinessException;
import br.com.ifba.sgif.api.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service que fornece operações relacionadas a Função de Técnico Administrativo.
 *
 * @author unknown
 * Editado por Andesson Reis
 * @since V1.0.1
 */
@Service
public class ServiceFuncaoTecnicoAdministrativo implements IServiceFuncaoTecnicoAdministrativo {

    @Autowired
    private IDaoFuncaoTecnicoAdministrativo funcaoTecnicoAdministrativoDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Salva uma Função Técnico Administrativo na base de dados e retorna um objeto DTO com os dados resumidos da Função Técnico Administrativo salva.
     *
     * @param funcaoTecnicoAdm - A Função Técnico Administrativo que será salva na base de dados.
     * @return um objeto DTO com os dados resumidos da Função Técnico Administrativo salva.
     */
    @Override
    public FuncaoTecnicoAdministrativoResponseDto saveFuncaoTecnicoAdm(FuncaoTecnicoAdministrativo funcaoTecnicoAdm) {
        return objectMapperUtil.map(
                funcaoTecnicoAdministrativoDao.save(funcaoTecnicoAdm),
                FuncaoTecnicoAdministrativoResponseDto.class);
    }

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Deleta uma Função Técnico Administrativo com base no ID.
     *
     * @param id - O ID da Função Técnico Administrativo a ser deletada.
     * @return um objeto DTO com os dados da Função Técnico Administrativo deletada.
     */
    @Override
    public FuncaoTecnicoAdministrativoResponseDto deleteFuncaoTecnicoAdm(Long id) {
        return this.funcaoTecnicoAdministrativoDao.findById(id)
                .map(funcaoTecnicoAdm -> {
                    funcaoTecnicoAdministrativoDao.delete(funcaoTecnicoAdm);
                    return objectMapperUtil.map(funcaoTecnicoAdm, FuncaoTecnicoAdministrativoResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Obtém uma lista de todas as Funções Técnico Administrativo como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as Funções Técnico Administrativo.
     */
    @Override
    public List<FuncaoTecnicoAdministrativoResponseDto> getAllFuncoesTecnicoAdm() {
        return objectMapperUtil.mapAll(
                this.funcaoTecnicoAdministrativoDao.findAll(),
                FuncaoTecnicoAdministrativoResponseDto.class);
    }
}
