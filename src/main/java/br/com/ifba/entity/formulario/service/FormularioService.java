package br.com.ifba.entity.formulario.service;

import br.com.ifba.entity.avaliacao.dao.IDaoAvaliacao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.ifba.entity.formulario.dto.FormularioResponseDto;
import br.com.ifba.entity.formulario.dto.FormularioSimpleResponseDto;
import br.com.ifba.entity.formulario.model.Formulario;
import br.com.ifba.entity.formulario.dao.IDaoFormulario;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.infrastructure.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Service
public class FormularioService implements IFormularioService {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoFormulario formularioDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;
    
    @Autowired
    private IDaoAvaliacao avaliacaoDao;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //


    /**
     * @author Giovane Neves
     * Desde V1.0.1
     *<p>
     * Lista todos os formulários da base de dados.
     * @return uma lista com todos os formulários na base de dados.
     */
    @Override
    public List<FormularioSimpleResponseDto> listarFormularios() {

        return objectMapperUtil.mapAll(
                this.formularioDao.findAll(),
                FormularioSimpleResponseDto.class
        );

    }

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * Encontra um formulário pelo ID passado por parâmetro.
     * @param id O ID do formulário a ser buscado na base de dados.
     * @return os dados do formulário atrelados àquele ID.
     */
    @Override
    public FormularioResponseDto encontrarFormularioPorId(UUID id) {

        return objectMapperUtil.map(
                formularioDao.findById(id)
                        .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())),
                FormularioResponseDto.class
        );

    }

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * Salva um formulário na base de dados.
     * @param formulario O formulário que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do formulário
     * salvo.
     */
    @Override
    public FormularioSimpleResponseDto salvarFormulario(Formulario formulario) {

        return Optional.of(formulario)
                .filter(form -> !this.formularioDao.existsByTitulo(form.getTitulo()))
                .map(form -> objectMapperUtil.map(this.formularioDao.save(form), FormularioSimpleResponseDto.class))
                .orElseThrow(() -> new BusinessException(
                        BusinessExceptionMessage.ATTRIBUTE_VALUE_ALREADY_EXISTS.getMensagemValorJaExiste("título"))
                );


    }

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * Atualiza um formulário existente na base de dados.
     * @param formulario - O formulário que será atualizado.
     * @return dados do formulário atualizado.
     */
    @Override
    public FormularioSimpleResponseDto atualizarFormulario(Formulario formulario) {

        return Optional.of(formulario)
                        .filter(form -> this.formularioDao.existsById(formulario.getId()))
                        .map(form -> objectMapperUtil.map(this.formularioDao.save(form), FormularioSimpleResponseDto.class))
                        .orElseThrow(
                                () -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem())
                        );

    }

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     *<p>
     * Deleta um formulário.
     * @param id O ID do formulário a ser deletado.
     * @return objeto DTO com os dados do formulário deletado.
     */
    @Override
    public FormularioSimpleResponseDto deletarFormularioPorId(UUID id) {

        // TODO: Analisar se é preciso adicionar uma lógica para verificar se existe uma avaliação atrelada ao formulário.

        return this.formularioDao.findById(id)
                .map(form -> {
                    formularioDao.delete(form);
                    return objectMapperUtil.map(form, FormularioSimpleResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));


    }
}
