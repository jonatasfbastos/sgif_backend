package br.com.ifba.entity.permissao.service;

import br.com.ifba.entity.permissao.dao.IDaoPermissao;
import br.com.ifba.entity.permissao.dto.PermissaoResponseDto;
import br.com.ifba.entity.permissao.model.Permissao;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author Andesson Reis
 * Desde V1.0.1
 */
@Service
public class ServicePermissao implements IServicePermissao {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoPermissao daoPermissao;


    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    @Override
    public PermissaoResponseDto savePermissao(Permissao permissao) {

        return objectMapperUtil.map(
            daoPermissao.save(permissao),PermissaoResponseDto.class);
    }

    @Override
    public String deletePermissao(Long id) {
        if (daoPermissao.existsById(id) == false) {
            throw new BusinessException(PERMISSAO_NAO_EXISTE);
        }
        Permissao permissao = daoPermissao.getReferenceById(id);
        if (permissao.getPerfis().isEmpty() == false) {
            throw new BusinessException(HA_PERFIL_ASSOCIADO);
        }
        if (permissao.getLinks().isEmpty() == false) {
            throw new BusinessException(HA_LINK_ASSOCIADO);
        }
        daoPermissao.deleteById(id);
        return PERMISSAO_DELETADA;
    }

    @Override
    public Permissao updatePermissao(Permissao permissao) {
        if (permissao.getNome().isEmpty()) {
            throw new BusinessException(CAMPO_VAZIO);
        }
        return daoPermissao.save(permissao);
    }

    @Override
    public List<Permissao> getAllPermissoes() {
        return daoPermissao.findAll();
    }

    @Override
    public List<Permissao> getAllByPerfilId(Long id) {
        return daoPermissao.findByPerfisId(id);
    }

    @Override
    public List<Permissao> getAllByLinkId(Long id) {
        return daoPermissao.findByLinksId(id);
    }

}