package br.com.ifba.entity.pessoa.service;

import java.util.List;
import java.util.Optional;

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
 * Editado por Andesson Reis
 * Desde V1.0.1
 */
@Service
public class ServicePessoa implements IServicePessoa {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoPessoa daoPessoa;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
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
                        BusinessExceptionMessage.ATTRIBUTE_VALUE_ALREADY_EXISTS.getMensagemValorJaExiste("CPF"))
                );
    }

    @Override
    public void delete(Pessoa pessoa) {
        if (pessoa == null) {
            throw new BusinessException(Pessoa_NULL);
        } else {
            this.daoPessoa.delete(pessoa);
            return;
        }
    }

    /**
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

    @Override
    public List<Pessoa> findByNome(String name) {
        if (name == null) {
            throw new BusinessException("Nome null");
        } else if (name.isEmpty()) {
            throw new BusinessException("Nome vazio");
        } else {
            return daoPessoa.findByNome(name);
        }
    }

    @Override
    public Pessoa findById(Long id) {
        Optional<Pessoa> pessoa = daoPessoa.findById(id);
        return pessoa.isPresent() ? pessoa.get() : null;
    }

    /*
     * @Override
     * public Pessoa findByLoginOrEmailAndSenha(String login, String email, String
     * senha) {
     * Optional<Pessoa> pessoa = daoPessoa.findByLoginOrEmailAndSenha(login, email,
     * senha);
     * return pessoa.isPresent() ? pessoa.get() : null;
     * }
     */
}
