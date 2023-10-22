package br.com.ifba.entity.funcaoterceirizado.service;

import br.com.ifba.entity.funcaoterceirizado.model.FuncaoTerceirizado;

import br.com.ifba.entity.funcaoterceirizado.dao.IDaoFuncaoTerceirizado;
import br.com.ifba.entity.funcaoterceirizado.dto.FuncaoTerceirizadoResponseDto;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    /**
     * Deleta uma Função de Terceirizado.
     *
     * @param id - O ID da Função de Terceirizado a ser deletada.
     * @return um objeto DTO com os dados da Função de Terceirizado deletada.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public FuncaoTerceirizadoResponseDto deleteFuncaoTerceirizado(UUID id) {

        return this.daoFuncaoTerceirizado.findById(id)
                .map(fun -> {
                    daoFuncaoTerceirizado.delete(fun);
                    return objectMapperUtil.map(fun, FuncaoTerceirizadoResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * Obtém uma lista de todas as Funções de Terceirizado como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as Funções de Terceirizado.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public List<FuncaoTerceirizadoResponseDto> getAllFuncoesTerceirizado() {
        return objectMapperUtil.mapAll(
                this.daoFuncaoTerceirizado.findAll(),
                FuncaoTerceirizadoResponseDto.class);
    }

}
