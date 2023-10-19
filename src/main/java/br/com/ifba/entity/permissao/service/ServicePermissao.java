package br.com.ifba.entity.permissao.service;

import br.com.ifba.entity.permissao.dao.IDaoPermissao;
import br.com.ifba.entity.permissao.dto.PermissaoResponseDto;
import br.com.ifba.entity.permissao.model.Permissao;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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
    public PermissaoResponseDto deletePermissao(Long id) {
        Permissao permissao =  daoPermissao.findById(id)
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        daoPermissao.delete(permissao);

        return objectMapperUtil.map(permissao,
                PermissaoResponseDto.class);
    }

    @Override
    public PermissaoResponseDto updatePermissao(Permissao permissao) {
        daoPermissao.findById(permissao.getId())
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        return objectMapperUtil.map(
                daoPermissao.save(permissao),
                PermissaoResponseDto.class);
    }

    @Override
    public List<PermissaoResponseDto> getAllPermissoes() {
         return daoPermissao.findAll().stream()
                .map(objectMapperUtil.mapFn(PermissaoResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PermissaoResponseDto> getAllByPerfilId(Long id) {

        return daoPermissao.findByPerfisId(id)
        .stream()
        .map(permissao -> objectMapperUtil.map(permissao, PermissaoResponseDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public List<Permissao> getAllByLinkId(Long id) {
        return daoPermissao.findByLinksId(id);
    }

}