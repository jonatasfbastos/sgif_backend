package br.com.ifba.sgif.api.entity.pessoa.service;

import java.util.List;
import java.util.UUID;

import br.com.ifba.sgif.api.entity.pessoa.dto.PessoaResponseDto;
import br.com.ifba.sgif.api.entity.pessoa.model.Pessoa;
import org.springframework.stereotype.Service;

/**
 * Serviço para operações relacionadas à entidade 'Pessoa'.
 *
 * @author matheus lima
 * Editado por Andesson Reis
 * Desde V1.0.1
 */

@Service
public interface IServicePessoa {

    /**
     * Salva uma Pessoa na base de dados e retorna um objeto DTO com os dados da pessoa salva.
     *
     * @param pessoa - A Pessoa que será salva na base de dados.
     * @return um objeto DTO com os dados da pessoa salva.
     */
    PessoaResponseDto savePessoa(Pessoa pessoa);

    /**
     * Deleta uma Pessoa.
     *
     * @param Id - O ID da pessoa a ser deletada.
     */
    PessoaResponseDto deleteById(UUID Id);

    /**
     * Obtém uma lista de todas as pessoas como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as pessoas.
     */
    List<PessoaResponseDto> getAllPessoas();

    /**
     * Encontra uma pessoa pelo ID.
     *
     * @param id - O ID da pessoa a ser encontrada.
     * @return um objeto DTO com os dados da pessoa encontrada.
     */
    PessoaResponseDto findById(UUID id);

    /**
     * Encontra pessoas pelo nome.
     *
     * @param name - O nome das pessoas a serem encontradas.
     * @return uma lista de objetos DTO representando as pessoas encontradas.
     */
    List<PessoaResponseDto> findByNome(String name);

}
