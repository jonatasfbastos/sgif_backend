package br.com.ifba.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Configuration
public class RoleHierarchyConfig {

    @Bean
    static RoleHierarchy roleHierarchy(){

        RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
        hierarchy.setHierarchy(
                "ROLE_ADMIN > ROLE_STAFF\n".concat(
                        "ROLE_STAFF > ROLE_USER\n".concat(
                                "ROLE_USER > ROLE_GUEST"
                        )
                )
        );

        return hierarchy;

    }

    @Bean
    static MethodSecurityExpressionHandler methodSecurityExpressionHandler(RoleHierarchy roleHierarchy) {

        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();

        expressionHandler.setRoleHierarchy(roleHierarchy);

        return expressionHandler;
    }

}
