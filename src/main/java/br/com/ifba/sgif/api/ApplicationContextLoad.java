package br.com.ifba.sgif.api;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Component
public class ApplicationContextLoad implements ApplicationContextAware {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private static ApplicationContext applicationContext;

    // =========================================================== //
    // =============== [         MÉTODOS      ] ================== //
    // =========================================================== //

    /**
     * Seta o contexto da aplicação.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param applicationContext O contexto da aplicação.
     * @throws BeansException caso haja algum erro interno.
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * Recupera o contexto da aplicação.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return o contexto da aplicação.
     */
    public static ApplicationContext getApplicationContext(){

        return applicationContext;

    }

}
