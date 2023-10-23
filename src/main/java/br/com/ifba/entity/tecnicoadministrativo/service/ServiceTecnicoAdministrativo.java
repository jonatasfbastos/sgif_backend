package br.com.ifba.entity.tecnicoadministrativo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

import br.com.ifba.entity.tecnicoadministrativo.dao.IDaoTecnicoAdministrativo;
import br.com.ifba.entity.tecnicoadministrativo.dto.TecnicoAdministrativoResponseDto;
import br.com.ifba.entity.tecnicoadministrativo.model.TecnicoAdministrativo;

/**
 * Service que fornece operações relacionadas a Técnico Administrativo.
 *
 * @author unknown
 * @since V1.0.1
 * @Editado por Andesson Reis
 */
@Service
public class ServiceTecnicoAdministrativo implements IServiceTecnicoAdministrativo {
    // =========================================================== //
    // =============== [ ATRIBUTOS ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoTecnicoAdministrativo tecnicoAdministrativoDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ MÉTODOS ] ================== //
    // =========================================================== //

    /**
     * Salva um Técnico Administrativo na base de dados e retorna um objeto DTO com os dados resumidos do Técnico Administrativo salvo.
     *
     * @param tecnicoAdministrativo - O Técnico Administrativo que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do Técnico Administrativo salvo.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public TecnicoAdministrativoResponseDto saveTecnicoAdministrativo(TecnicoAdministrativo tecnicoAdministrativo) {
        return objectMapperUtil.map(
                tecnicoAdministrativoDao.save(tecnicoAdministrativo),
                TecnicoAdministrativoResponseDto.class);
    }

    /**
     * Atualiza um Técnico Administrativo na base de dados e retorna um objeto DTO com os dados resumidos do Técnico Administrativo atualizado.
     *
     * @param tecnicoAdministrativo - O Técnico Administrativo que será atualizado na base de dados.
     * @return um objeto DTO com os dados resumidos do Técnico Administrativo atualizado.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public TecnicoAdministrativoResponseDto updateTecnicoAdministrativo(TecnicoAdministrativo tecnicoAdministrativo) {
        tecnicoAdministrativoDao.findById(tecnicoAdministrativo.getId())
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        return objectMapperUtil.map(
                tecnicoAdministrativoDao.save(tecnicoAdministrativo),
                TecnicoAdministrativoResponseDto.class);
    }

    @Override
    public List<TecnicoAdministrativo> getAllTecnicoAdministrativo() {
        return this.tecnicoAdministrativoDao.findAll();
    }

    @Override
    public List<TecnicoAdministrativo> findByNome(String nome) {
        if (nome == null) {
            throw new BusinessException(NOME_NULL);
        }
        if (nome.isEmpty()) {
            throw new BusinessException(NOME_VAZIO);
        }
        return tecnicoAdministrativoDao.findByNome(nome);
    }

    @Override
    public TecnicoAdministrativo findById(Long id) {
        return tecnicoAdministrativoDao.getReferenceById(id);
    }

    /**
     * Deleta um Técnico Administrativo com base no ID.
     *
     * @param id - O ID do Técnico Administrativo a ser deletado.
     * @return um objeto DTO com os dados do Técnico Administrativo deletado.
     * @author Andesson Reis
     * @since V1.0.1
     */
    @Override
    public TecnicoAdministrativoResponseDto deleteTecnicoAdministrativo(UUID id) {
        
        return this.tecnicoAdministrativoDao.findById(id)
                .map(tecnicoAdministrativo -> {
                    tecnicoAdministrativoDao.delete(tecnicoAdministrativo);
                    return objectMapperUtil.map(tecnicoAdministrativo, TecnicoAdministrativoResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }

}
