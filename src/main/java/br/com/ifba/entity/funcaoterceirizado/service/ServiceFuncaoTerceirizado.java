package br.com.ifba.entity.funcaoterceirizado.service;

import br.com.ifba.entity.funcaoterceirizado.model.FuncaoTerceirizado;

import br.com.ifba.entity.funcaoterceirizado.dao.IDaoFuncaoTerceirizado;
import br.com.ifba.entity.funcaoterceirizado.dto.FuncaoTerceirizadoResponseDto;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service que fornece operações relacionadas a FuncaoTerceirizado
 *
 * @author ph715
 * @since V1.0.1
 * @Editado por Andesson Reis
 */
@Service
public class ServiceFuncaoTerceirizado implements IServiceFuncaoTerceirizado {
    // =========================================================== //
    // ======================== [ ATRIBUTOS ] ==================== //
    // =========================================================== //

    @Autowired
    private IDaoFuncaoTerceirizado daoFuncaoTerceirizado;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // ======================== [ MÉTODOS ] ====================== //
    // =========================================================== //

    /**
     * Salva uma Função de Terceirizado na base de dados e retorna um objeto DTO com
     * os dados resumidos da Função salva.
     *
     * @param funcaoTerceirizado - A Função de Terceirizado que será salva na base
     *                           de dados.
     * @return um objeto DTO com os dados resumidos da Função salva.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public FuncaoTerceirizadoResponseDto saveFuncaoTerceirizado(FuncaoTerceirizado funcaoTerceirizado) {

        return Optional.of(funcaoTerceirizado)
                .filter(fun -> !this.daoFuncaoTerceirizado.existsByNome(fun.getNome()))
                .map(fun -> objectMapperUtil.map(this.daoFuncaoTerceirizado.save(fun),
                        FuncaoTerceirizadoResponseDto.class))
                .orElseThrow(() -> new BusinessException(
                        BusinessExceptionMessage.ATTRIBUTE_VALUE_ALREADY_EXISTS.getMensagemValorJaExiste("nome")));
    }

    @Override
    public String deleteFuncaoTerceirizado(Long id) {
        if (daoFuncaoTerceirizado.existsById(id) == false) {
            throw new BusinessException(FUNCAO_NAO_EXISTE);
        }
        daoFuncaoTerceirizado.delete(daoFuncaoTerceirizado.getReferenceById(id));
        return FUNCAO_DELETADA;
    }

    @Override
    public List<FuncaoTerceirizado> getAllFuncoesTerceirizado() {
        return daoFuncaoTerceirizado.findAll();
    }

}
