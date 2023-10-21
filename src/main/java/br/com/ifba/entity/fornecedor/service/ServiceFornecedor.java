package br.com.ifba.entity.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ifba.entity.fornecedor.dao.IDaoFornecedor;
import br.com.ifba.entity.fornecedor.dto.FornecedorResponseDto;
import br.com.ifba.entity.fornecedor.model.Fornecedor;
import br.com.ifba.entity.perfilusuario.dao.IDaoPerfilUsuario;
import br.com.ifba.entity.perfilusuario.dto.PerfilUsuarioResponseDto;
import br.com.ifba.infrastructure.exception.BusinessException;
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

    @Override
    public Fornecedor updateFornecedor(Fornecedor fornecedor) {
        if (fornecedor == null) {
            throw new BusinessException(FORNECEDOR_NULL);
        } else if (daoFornecedor.findById(fornecedor.getId()) == null) {
            throw new BusinessException(FORNECEDOR_EXISTE);
        } else {
            return daoFornecedor.save(fornecedor);
        }
    }

    @Override
    public void deleteFornecedor(Fornecedor fornecedor) {
        if (fornecedor == null) {
            throw new BusinessException(FORNECEDOR_NULL);
        } else {
            this.daoFornecedor.delete(fornecedor);
            return;
        }
    }

    @Override
    public List<Fornecedor> getAllFornecedor() {
        return daoFornecedor.findAll();
    }

}
