package br.com.ifba.entity.pessoa.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.ifba.entity.pessoa.dao.IDaoPessoa;
import br.com.ifba.entity.pessoa.dto.PessoaResponseDto;
import br.com.ifba.entity.pessoa.model.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifba.infrastructure.exception.BusinessException;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @author matheus lima
 *Editado por Andesson Reis
 *Desde V1.0.1
 */
@Service
public class ServicePessoa implements IServicePessoa {

    // =========================================================== //
    // =============== [ ATRIBUTOS ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoPessoa daoPessoa;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ MÉTODOS ] ================== //
    // =========================================================== //

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Salva uma pessoa na base de dados.
     * @param pessoa A pessoa que será salvo na base de dados.
     * @return um objeto DTO com os dados da pessoa salvo
     * 
     */
    @Override
    public PessoaResponseDto savePessoa(Pessoa pessoa) {

        return Optional.of(pessoa)
                .filter(form -> !this.daoPessoa.existsByCpf(form.getCpf()))
                .map(form -> objectMapperUtil.map(this.daoPessoa.save(form), PessoaResponseDto.class))
                .orElseThrow(() -> new BusinessException(
                        BusinessExceptionMessage.ATTRIBUTE_VALUE_ALREADY_EXISTS.getMensagemValorJaExiste("CPF")));
    }

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     *Deleta uma pessoa atrelado ao ID passado por parâmetro.
     * @param id O ID do pessoa a ser deletado.
     * 
     * @return Dados de uma pessoa deletada deletado.
     */
    @Override
    public PessoaResponseDto deleteById(UUID id) {

        return this.daoPessoa.findById(id)
                .map(pessoa -> {
                    daoPessoa.delete(pessoa);
                    return objectMapperUtil.map(pessoa, PessoaResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

    }

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Obtém uma lista de todas as pessoas como objetos DTO.
     *
     * @return uma lista de objetos DTO representando as pessoas.
     */
    @Override
    public List<PessoaResponseDto> getAllPessoas() {

        return objectMapperUtil.mapAll(
                this.daoPessoa.findAll(),
                PessoaResponseDto.class);
    }

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra pessoas pelo nome.
     *
     * @param name - O nome das pessoas a serem encontradas.
     * @return uma lista de objetos DTO representando as pessoas encontradas.
     */
    @Override
    public List<PessoaResponseDto> findByNome(String name) {

        return objectMapperUtil.mapAll(
                this.daoPessoa.findByNome(name),
                PessoaResponseDto.class);

    }

    /**
     * @author Andesson Reis
     * @since Desde V1.0.1
     * 
     * Encontra uma pessoa pelo ID.
     *
     * @param id - O ID da pessoa a ser encontrada.
     * @return um objeto DTO com os dados da pessoa encontrada.
     */
    @Override
    public PessoaResponseDto findById(UUID id) {
        return daoPessoa.findById(id)
                .map(objectMapperUtil.mapFn(PessoaResponseDto.class))
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));
    }
}
