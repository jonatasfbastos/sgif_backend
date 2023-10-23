package br.com.ifba.entity.funcaotecnicoadministrativo.service;

import br.com.ifba.entity.funcaotecnicoadministrativo.dao.IDaoFuncaoTecnicoAdministrativo;
import br.com.ifba.entity.funcaotecnicoadministrativo.dto.FuncaoTecnicoAdministrativoResponseDto;
import br.com.ifba.entity.funcaotecnicoadministrativo.model.FuncaoTecnicoAdministrativo;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

/**
 * Service que fornece operações relacionadas a Função de Técnico Administrativo.
 *
 * @author unknown
 * @since V1.0.1
 * @Editado por Andesson Reis
 */

@Service
public class ServiceFuncaoTecnicoAdministrativo implements IServiceFuncaoTecnicoAdministrativo {


    @Autowired
    private IDaoFuncaoTecnicoAdministrativo funcaoTecnicoAdministrativoDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;


    /**
     * Salva uma Função Técnico Administrativo na base de dados e retorna um objeto DTO com os dados resumidos da Função Técnico Administrativo salva.
     *
     * @param funcaoTecnicoAdm - A Função Técnico Administrativo que será salva na base de dados.
     * @return um objeto DTO com os dados resumidos da Função Técnico Administrativo salva.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public FuncaoTecnicoAdministrativoResponseDto saveFuncaoTecnicoAdm(FuncaoTecnicoAdministrativo funcaoTecnicoAdm) {
        
        return objectMapperUtil.map(
                funcaoTecnicoAdministrativoDao.save(funcaoTecnicoAdm),
                FuncaoTecnicoAdministrativoResponseDto.class);
    }

    /**
     * Deleta uma Função Técnico Administrativo com base no ID.
     *
     * @param id - O ID da Função Técnico Administrativo a ser deletada.
     * @return um objeto DTO com os dados da Função Técnico Administrativo deletada.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public FuncaoTecnicoAdministrativoResponseDto deleteFuncaoTecnicoAdm(UUID id) {

        return this.funcaoTecnicoAdministrativoDao.findById(id)
                .map(funcaoTecnicoAdm -> {
                    funcaoTecnicoAdministrativoDao.delete(funcaoTecnicoAdm);
                    return objectMapperUtil.map(funcaoTecnicoAdm, FuncaoTecnicoAdministrativoResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    @Override
    public List<FuncaoTecnicoAdministrativo> getAllFuncoesTecnicoAdm() {
        return daoFuncaoTecnicoAdministrativo.findAll();
    }

}