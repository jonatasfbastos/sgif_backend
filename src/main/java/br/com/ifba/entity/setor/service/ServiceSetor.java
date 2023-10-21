package br.com.ifba.entity.setor.service;

import java.util.List;

import javax.validation.Valid;

import br.com.ifba.entity.setor.dao.IDaoSetor;
import br.com.ifba.entity.setor.dto.SetorResponseDto;
import br.com.ifba.entity.setor.model.Setor;
import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Everton.
 * @Editado por Andesson Reis
 * @since V1.0.1
 * 
 * Service que fornece operações relacionadas a Setor
 * 
 * Esta classe contém métodos para criar, atualizar, excluir e recuperar
 * informações de setor.
 */
@Service
public class ServiceSetor implements IServiceSetor {

    // =========================================================== //
    // ======================= [ ATRIBUTOS ] ===================== //
    // =========================================================== //

    @Autowired
    private IDaoSetor daoSetor;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // ========================= [ MÉTODOS ] ===================== //
    // =========================================================== //

    /**
     * Salva um setor na base de dados e retorna um objeto DTO com os dados
     * do setor salvo.
     *
     * @param setor - O setor que será salvo na base de dados.
     * @return um objeto DTO com os dados do setor salvo.
     */
    @Override
    public SetorResponseDto saveSetor(@Valid Setor setor) {
       
        return objectMapperUtil.map(
                daoSetor.save(setor),
                SetorResponseDto.class);
    }

    @Override
    public Setor updateSetor(Setor setor) {
        if (setor == null) {
            throw new BusinessException(SETOR_NULL);
        } else if (daoSetor.findById(setor.getId()) == null) {
            throw new BusinessException(SETOR_NAO_EXISTE);
        } else {
            return daoSetor.save(setor);
        }
    }

    @Override
    public void deleteSetor(Setor setor) {
        if (setor == null) {
            throw new BusinessException(SETOR_NULL);
        } else {
            daoSetor.delete(setor);
        }
    }

    @Override
    public List<Setor> getAllSetor() {
        return this.daoSetor.findAll();
    }

}
