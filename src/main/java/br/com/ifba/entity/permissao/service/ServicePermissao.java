package br.com.ifba.entity.permissao.service;

import br.com.ifba.entity.permissao.dao.IDaoPermissao;
import br.com.ifba.entity.permissao.model.Permissao;
import br.com.ifba.infrastructure.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicePermissao implements IServicePermissao {

    private final static String CAMPO_VAZIO = "Há campo vazio, preencha e tente novamente.";
    private final static String PERMISSAO_NAO_EXISTE = "A permissão informada não existe.";
    private final static String PERMISSAO_EXISTE = "A permissão informada já existe.";
    private final static String PERMISSAO_DELETADA = "Permissão deletada com sucesso.";
    private final static String HA_PERFIL_ASSOCIADO = "Não foi possível deletar a permissão, há perfil associado a esta permissão.";
    private final static String HA_LINK_ASSOCIADO = "Não foi possível deletar a permissão, há link associado a esta permissão.";

    @Autowired
    private IDaoPermissao daoPermissao;

    @Override
    public Permissao savePermissao(Permissao permissao) {
        if (permissao.getNome().isEmpty()) {
            throw new BusinessException(CAMPO_VAZIO);
        }
        if (daoPermissao.existsByNome(permissao.getNome())) {
            throw new BusinessException(PERMISSAO_EXISTE);
        }
        return daoPermissao.save(permissao);
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