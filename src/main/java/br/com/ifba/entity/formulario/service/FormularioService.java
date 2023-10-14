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

@Service
public class FormularioService implements IFormularioService {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    //mensagem de erro caso o Formulario seja nulo;
    public final static String FORMULARIO_NULL = "Dados do Formulario nao preenchidos";

    //mensagem de erro caso o Formulario jÃ¡ exista no banco de dados;
    public final static String FORMULARIO_EXISTE = "Formulario ja existente no Banco de dados";

    //mensagem de erro caso o Formulario nÃ£o exista no banco de dados;
    public final static String FORMULARIO_NAO_EXISTE = "Formulario nao existente no Banco de dados";

    //mensagem de erro caso o Formulario seja invÃ¡lido;
    public final static String FORMULARIO_INVALIDO = "As informacoes do Formulario nao sao validas";
    
    //mensagem de erro caso o Formulario seja invÃ¡lido;
    public final static String CAMPO_VAZIO = "Campos nao preenchidos";
    
    //mensagem de erro em remoção de Formulário que tenha uma Avaliação atrelada
    public final static String IMPOSSIVEL_REMOVER = "Existe uma avaliacao atrelada ao formulario";

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

    /*
    @Override
    public void deleteFormulario(Formulario formulario) {
        if (formulario == null) {
            throw new BusinessException(FORMULARIO_NULL);
        } else if (this.formularioDao.existsById(formulario.getId()) == true) {
            Avaliacao avaliacao = formulario.getAvaliacao();
            if (avaliacao.equals(this.avaliacaoDao.getReferenceById(avaliacao.getId()))) {
                throw new BusinessException(IMPOSSIVEL_REMOVER);
            } else {
                this.formularioDao.delete(formulario);
            }
        }
        throw new BusinessException(FORMULARIO_NAO_EXISTE);
    }
    */

    @Override
    public void deletarFormulario(Long id) {
        if (this.formularioDao.existsById(id) == false) {
            throw new BusinessException(FORMULARIO_NAO_EXISTE);
        }
        Avaliacao avaliacao = this.formularioDao.getReferenceById(id).getAvaliacao();
        if (avaliacao.equals(this.avaliacaoDao.getReferenceById(avaliacao.getId()))) {
            throw new BusinessException(IMPOSSIVEL_REMOVER);
        } else {
            this.formularioDao.delete(formularioDao.getReferenceById(id));
        }
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
