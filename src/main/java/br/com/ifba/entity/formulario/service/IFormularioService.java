package br.com.ifba.entity.formulario.service;

import java.util.List;

import br.com.ifba.entity.formulario.dto.FormularioResponseDto;
import br.com.ifba.entity.formulario.dto.FormularioSimpleResponseDto;
import br.com.ifba.entity.formulario.model.Formulario;

public interface IFormularioService {

    List<FormularioSimpleResponseDto> listarFormularios();

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     *
     * Encontra um formulário pelo ID passado por parâmetro.
     *
     * @param id O ID do formulário a ser buscado na base de dados.
     * @return os dados do formulário atrelados àquele ID.
     */
    FormularioResponseDto encontrarFormularioPorId(Long id);

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     *
     * Salva um formulário na base de dados.
     *
     * @param formulario O formulário que será salvo na base de dados.
     * @return um objeto DTO com os dados resumidos do formulário
     * salvo.
     */
    FormularioSimpleResponseDto salvarFormulario(Formulario formulario);

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     *
     * Atualiza um formulário existente na base de dados
     *
     * @param formulario O formulário que será atualizado.
     * @return dados do formulário atualizado.
     */
    FormularioSimpleResponseDto atualizarFormulario(Formulario formulario);

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     *
     * Deleta um formulário.
     *
     * @param id O ID do formulário a ser deletado.
     * @return objeto DTO com os dados do formulário deletado.
     */
    FormularioSimpleResponseDto deletarFormularioPorId(Long id);



    // MÃ©todo que retorna a lista com os Formularios com o nome informado
    List<Formulario> encontrarFormularioPorTitulo(String titulo);
    
}
