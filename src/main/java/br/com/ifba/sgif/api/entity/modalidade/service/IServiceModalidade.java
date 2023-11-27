package br.com.ifba.sgif.api.entity.modalidade.service;

import java.util.List;

import br.com.ifba.sgif.api.entity.modalidade.dto.ModalidadeResponseDto;
import br.com.ifba.sgif.api.entity.modalidade.model.Modalidade;

/**
 * Interface de serviço para Modalidade.
 *
 * @author unknown
 * @since V1.0.1
 * Editado por Andesson Reis
 * 
 */
public interface IServiceModalidade {

    /**
     * Salva uma Modalidade na base de dados e retorna um objeto DTO com os dados resumidos da Modalidade salva.
     *
     * @param modalidade - A Modalidade que será salva na base de dados.
     * @return um objeto DTO com os dados resumidos da Modalidade salva.
     */
    ModalidadeResponseDto saveModalidade(Modalidade modalidade);

    /**
     * Atualiza uma Modalidade na base de dados e retorna um objeto DTO com os dados resumidos da Modalidade atualizada.
     *
     * @param modalidade - A Modalidade que será atualizada na base de dados.
     * @return um objeto DTO com os dados resumidos da Modalidade atualizada.
     */
    ModalidadeResponseDto updateModalidade(Modalidade modalidade);

    /**
     * Deleta uma Modalidade com base no ID.
     *
     * @param id - O ID da Modalidade a ser deletada.
     * @return um objeto DTO com os dados da Modalidade deletada.
     */
    ModalidadeResponseDto deleteModalidade(Long id);

    /**
     * Obtém uma lista de todas as Modalidades como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as Modalidades.
     */
    List<ModalidadeResponseDto> getAllModalidade();
}
