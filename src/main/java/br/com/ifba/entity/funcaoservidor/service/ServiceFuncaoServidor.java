package br.com.ifba.entity.funcaoservidor.service;

import br.com.ifba.entity.empenho.dao.IDaoEmpenho;
import br.com.ifba.entity.funcaoservidor.dao.IDaoFuncaoServidor;
import br.com.ifba.entity.funcaoservidor.dto.FuncaoServidorResponseDto;
import br.com.ifba.entity.funcaoservidor.model.FuncaoServidor;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.entity.tecnicoadministrativo.dao.IDaoTecnicoAdministrativo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

    @Override
    public void deleteFuncaoServidor(FuncaoServidor funcaoServidor) {
        if(funcaoServidor == null) {
            throw new BusinessException(FUNCAO_NULL);
        } 
        if(daoFuncaoServidor.existsById(funcaoServidor.getId()) == false) {
            throw new BusinessException(FUNCAO_NAO_EXISTE);
        }
        if(daoFuncaoServidor.getReferenceById(funcaoServidor.getId()).getTecnicoAdministrativos().isEmpty() == false){
            throw new BusinessException(TECNICO_EXISTE);
        }
        daoFuncaoServidor.delete(funcaoServidor);
    }

    @Override
    public List<FuncaoServidor> getAllFuncaoServidor() {
        return daoFuncaoServidor.findAll();
    }

    @Override
    public FuncaoServidor updateFuncaoServidor(FuncaoServidor funcaoServidor) {
        if (funcaoServidor == null) {
            throw new BusinessException(FUNCAO_NULL);
        } else if (daoFuncaoServidor.findById(funcaoServidor.getId()) == null) {
            throw new BusinessException(FUNCAO_EXISTE);
        } else {
            return daoFuncaoServidor.save(funcaoServidor);
        }
    }

}