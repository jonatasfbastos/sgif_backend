package br.com.ifba.entity.formulario.service;

import java.util.List;

import br.com.ifba.entity.formulario.dto.FormularioResponseDto;
import br.com.ifba.entity.formulario.model.Formulario;

public interface IFormularioService {

    List<FormularioResponseDto> listarFormularios();

    /**
     * Salva um formulário na base de dados.
     *
     * @param formulario - O formulário que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do formulário
     * salvo.
     */
    FormularioResponseDto salvarFormulario(Formulario formulario);

    /**
     * Atualiza um formulário existente na base de dados
     * @param formulario - O formulário que será atualizado.
     * @return dados do formulário atualizado.
     */
    FormularioResponseDto atualizarFormulario(Formulario formulario);

    // Deleta o formulário por id
    void deletarFormulario(Long id);

    // Metodo que retorna todos os Formularios da base de dados

    // MÃ©todo que retorna o Formulario com o id informado
    Formulario encontrarFormularioPorId(Long id);
    
    // MÃ©todo que retorna a lista com os Formularios com o nome informado
    List<Formulario> encontrarFormularioPorTitulo(String titulo);
    
}
