package br.com.ifba.entity.aluno.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.ifba.entity.aluno.dao.IAlunoDao;
import br.com.ifba.entity.aluno.dto.AlunoResponseDto;
import br.com.ifba.entity.aluno.model.Aluno;
import br.com.ifba.entity.pessoa.dao.IDaoPessoa;
import br.com.ifba.infrastructure.exception.BusinessExceptionMessage;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
import br.com.ifba.infrastructure.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Unknown
 * Editado por Giovane Neves
 * Desde V1.0.1
 */
@Service
public class AlunoService implements IAlunoService {
    

    // =========================================================== //
    // =============== [       ATRIBUTOS        ] ================ //
    // =========================================================== //

    @Autowired
    private IAlunoDao alunoDao;

    @Autowired
    private IDaoPessoa pessoaDao;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [       MÉTODOS          ] ================ //
    // =========================================================== //

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * Lista todos os alunos presentes na base de dados.
     * @return uma lista com todos os alunos da base de dados, ou nulo caso não exista nenhuma.
     */
    @Override
    public List<AlunoResponseDto> listarAlunos() {

        return objectMapperUtil.mapAll(
                this.alunoDao.findAll(),
                AlunoResponseDto.class
        );

    }

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * Salva um aluno na base de ddados.
     * @param aluno - O Aluno que será salvo na base de dados.
     * @return um objeto DTO com os dados do aluno salvo na base de dados,
     * caso a operação ocorra com sucesso.
     *
     */
    @Override
    public AlunoResponseDto salvarAluno(Aluno aluno) {

        boolean existsByMatricula = this.alunoDao.existsByMatricula(aluno.getMatricula());
        return Optional.of(aluno)
                .filter(al -> !existsByMatricula)
                .filter(al -> !this.pessoaDao.existsByCpf(al.getCpf()))
                .map(al -> objectMapperUtil.map(this.alunoDao.save(al), AlunoResponseDto.class))
                .orElseThrow(
                        () -> new BusinessException(BusinessExceptionMessage.ATTRIBUTE_VALUE_ALREADY_EXISTS.getMensagemValorJaExiste(existsByMatricula ? "matrícula" : "CPF"))
                );

    }

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * Atualiza os dados de uma aluno existente na base de dados.
     * @param aluno - O Aluno que terá os seus dados atualizados.
     * @return os dados atualizados do aluno.
     */
    @Override
    public AlunoResponseDto atualizarAluno(Aluno aluno) {

        boolean alunoExists = this.alunoDao.findById(aluno.getId()).isPresent();

        return Optional.of(aluno)
                .filter(al -> alunoExists)
                .filter(al -> this.alunoDao.existsByMatricula(aluno.getMatricula()))
                .map(al -> objectMapperUtil.map(this.alunoDao.save(al), AlunoResponseDto.class))
                .orElseThrow(
                        () -> new BusinessException(!alunoExists
                                ? BusinessExceptionMessage.NOT_FOUND.getMensagem()
                                : BusinessExceptionMessage.ATTRIBUTE_VALUE_ALREADY_EXISTS.getMensagemValorJaExiste("matrícula")
                        )
                );

    }

    /**
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * Deleta um aluno da base de dados.
     * @param id O id do aluno que será deletado da base de dados.
     *
     */
    @Override
    public AlunoResponseDto deletarAlunoPorId(UUID id) {

        return this.alunoDao.findById(id)
                .map(al -> {
                    this.alunoDao.delete(al);
                    return objectMapperUtil.map(al, AlunoResponseDto.class);
                })
                .orElseThrow(() -> new BusinessException(BusinessExceptionMessage.NOT_FOUND.getMensagem()));

    }


    /**
     * AVISO: Temporariamente desabilitada enquanto não é entendida a sua utilidade.
     */
    @Override
    public List<Aluno> findByStatusAlunoId(Long id) {
        return alunoDao.findByStatusAlunoId(id);
    }
}
