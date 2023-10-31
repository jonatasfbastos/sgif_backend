package br.com.ifba.entity.empenho.service;

import br.com.ifba.entity.empenho.dao.IDaoEmpenho;
import br.com.ifba.entity.empenho.dto.EmpenhoResponseDto;
import br.com.ifba.entity.empenho.model.Empenho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Interface para serviços relacionados à entidade Empenho.
 *
 * @author rocki.julius
 * Editado por Andesson Reis
 * @since V1.0.1
 * 
 *Veja também: {@link br.com.ifba.entity.empenho.model.Empenho}
 */
@Service
public class ServiceEmpenho implements IServiceEmpenho {

    @Autowired
    private IDaoEmpenho daoEmpenho;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Salva um empenho (Response DTO) na base de dados.
     *
     * @param empenho O empenho (Response DTO) a ser salvo.
     * @return O empenho (Response DTO) salvo.
     */
    @Override
    public EmpenhoResponseDto saveEmpenho(Empenho empenho) {
        return objectMapperUtil.map(
                daoEmpenho.save(empenho),
                EmpenhoResponseDto.class);
    }

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Atualiza um empenho (Response DTO) na base de dados.
     *
     * @param empenho O empenho (Response DTO) a ser atualizado.
     * @return O empenho (Response DTO) atualizado.
     * @throws BusinessException se o empenho com o ID especificado não existe.
     */
    @Override
    public EmpenhoResponseDto updateEmpenho(Empenho empenho) {

        return Optional.of(empenho)
                .filter(emp -> this.daoEmpenho.existsById(empenho.getId()))
                .map(emp -> objectMapperUtil.map(this.daoEmpenho.save(emp), EmpenhoResponseDto.class))
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * @author Andesson Reis
     * @since V1.0.1
     * <p>
     * Deleta um empenho com base no seu ID.
     *
     * @param id O ID do empenho a ser excluído.
     * @return O empenho (Response DTO) que foi deletado.
     * @throws BusinessException se o empenho com o ID especificado não existe.
     */
    @Override
    public EmpenhoResponseDto deleteEmpenho(UUID id) {

        return this.daoEmpenho.findById(id)
                .map(empenho -> {
                    daoEmpenho.delete(empenho);
                    return objectMapperUtil.map(empenho, EmpenhoResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

    /**
     * @since V1.0.1
     * @author Andesson Reis
     * <p>
     * Obtém uma lista de todos os empenhos (Response DTOs) cadastrados na base de dados.
     *
     * @return Uma lista de empenhos (Response DTOs).
     * @throws BusinessException se ocorrer um erro ao recuperar a lista de empenhos.
     */
    @Override
    public List<EmpenhoResponseDto> getAllEmpenho() {

        return objectMapperUtil.mapAll(
                this.daoEmpenho.findAll(),
                EmpenhoResponseDto.class);
    }
}
