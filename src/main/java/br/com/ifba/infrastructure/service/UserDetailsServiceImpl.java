package br.com.ifba.infrastructure.service;

import br.com.ifba.entity.usuario.dao.IDaoUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private IDaoUsuario usuarioDao;


    // =========================================================== //
    // =============== [         MÉTODOS      ] ================== //
    // =========================================================== //

    /**
     * Carrega um usuário da base de dados pelo login passado por parâmetro.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param login O login do usuário a ser buscado.
     * @return dados do usuário com o login passo passado por parâmetro.
     * @throws UsernameNotFoundException caso não exista um usuário com o
     * login passado por parâmetro na base de dados.
     */
    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {

        return usuarioDao.findUserByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));

    }
}
