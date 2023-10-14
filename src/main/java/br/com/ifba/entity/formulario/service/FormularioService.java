package br.com.ifba.entity.formulario.service;

import br.com.ifba.entity.avaliacao.dao.IDaoAvaliacao;
import br.com.ifba.entity.avaliacao.model.Avaliacao;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.ifba.entity.formulario.dto.FormularioResponseDto;
import br.com.ifba.entity.formulario.model.Formulario;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.ifba.entity.formulario.dao.IDaoFormulario;
import br.com.ifba.infrastructure.exception.BusinessException;
import org.springframework.stereotype.Service;

/**
 * @author Giovane Neves
 * Desde V1.0.1
 */
@Service
public class FormularioService implements IFormularioService {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoFormulario formularioDao;
    
    @Autowired
    private IDaoAvaliacao avaliacaoDao;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    @Override
    public List<FormularioResponseDto> listarFormularios() {
        return this.formularioDao.findAll()
                .stream()
                .map(Formulario::toResponseDto)
                .collect(Collectors.toList());
    }

    /**
     *
     * Salva um formulário na base de dados.
     *
     * @param formulario - O formulário que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do formulário
     * salvo.
     */
    @Override
    public FormularioResponseDto salvarFormulario(Formulario formulario) {

        return formularioDao.save(formulario).toResponseDto();

    }

    /**
     * Atualiza um formulário existente na base de dados.
     *
     * @param formulario - O formulário que será atualizado.
     * @return dados do formulário atualizado.
     */
    @Override
    public FormularioResponseDto atualizarFormulario(Formulario formulario) {

        formularioDao.findById(formulario.getId())
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        return formularioDao.save(formulario).toResponseDto();
    }

    /**
     * Deleta um formulário.
     *
     * @param id O ID do formulário a ser deletado.
     * @return objeto DTO com os dados do formulário deletado.
     */
    @Override
    public FormularioResponseDto deletarFormularioPorId(Long id) {

        Formulario formulario = formularioDao.findById(id)
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

        // TODO: Analisar se é preciso adicionar uma lógica para verificar se existe uma avaliação atrelada ao formulário.

        formularioDao.delete(formulario);

        return formulario.toResponseDto();

    }

    @Override
    public Formulario encontrarFormularioPorId(Long id) {
        return formularioDao.getReferenceById(id);
    }

    @Override
    public List<Formulario> encontrarFormularioPorTitulo(String titulo) {
        if (titulo == null) {
            throw new BusinessException("Dados do titulo nao preenchidos");
        } else if (titulo.isEmpty()) {
            throw new BusinessException("O Campo titulo esta vazio");
        } else {
            return formularioDao.findByTitulo(titulo);
        }
    }
}
