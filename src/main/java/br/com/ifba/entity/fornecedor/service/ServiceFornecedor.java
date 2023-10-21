package br.com.ifba.entity.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
  
import br.com.ifba.entity.fornecedor.dao.IDaoFornecedor;
import br.com.ifba.entity.fornecedor.dto.FornecedorResponseDto;
import br.com.ifba.entity.fornecedor.model.Fornecedor;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @author vitor
 * @Editado por Andesson Reis
 * @since V1.0.1
 * 
 * Service que fornece operações relacionadas a perfis de usuário
 * 
 * Esta classe contém métodos para criar, atualizar, excluir e recuperar
 * informações de Fornecedor.
 *
 */
@Service
public class ServiceFornecedor implements IServiceFornecedor {

     // =========================================================== //
    // =============== [ ATRIBUTOS ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoFornecedor daoFornecedor;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ MÉTODOS ] ================== //
    // =========================================================== //

   /**
     * Salva um fornecedor (Response DTO) na base de dados.
     *
     * @param fornecedor O fornecedor (Response DTO) a ser salvo.
     * @return O fornecedor (Response DTO) salvo.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public FornecedorResponseDto saveFornecedor(Fornecedor fornecedor) {
        return objectMapperUtil.map(
                daoFornecedor.save(fornecedor),
                FornecedorResponseDto.class);
    }

    /**
     * Atualiza um fornecedor (Response DTO) na base de dados.
     *
     * @param fornecedor O fornecedor (Response DTO) a ser atualizado.
     * @return O fornecedor (Response DTO) atualizado.
     * @throws BusinessException se o fornecedor não existe na base de dados.
     */
    @Override
    public FornecedorResponseDto updateFornecedor(Fornecedor fornecedor) {
        return Optional.of(fornecedor)
                .filter(forn -> this.daoFornecedor.existsById(fornecedor.getId()))
                .map(forn -> objectMapperUtil.map(this.daoFornecedor.save(forn), FornecedorResponseDto.class))
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                );
    }


    /**
     * Deleta um fornecedor (Response DTO) com base no seu ID.
     *
     * @param id O ID do fornecedor a ser deletado.
     * @return O fornecedor (Response DTO) que foi deletado.
     * @throws BusinessException se o fornecedor com o ID especificado não existe.
     */
    @Override
    public FornecedorResponseDto deleteFornecedor(UUID id) {
        return this.daoFornecedor.findById(id)
                .map(forn -> {
                    daoFornecedor.delete(forn);
                    return objectMapperUtil.map(forn, FornecedorResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }


    @Override
    public List<Fornecedor> getAllFornecedor() {
        return daoFornecedor.findAll();
    }

}
