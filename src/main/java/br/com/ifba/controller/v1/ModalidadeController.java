package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.modalidade.service.IServiceModalidade;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
/**
 * @author Andesson Reis
 * @since Desde V1.0.1
 */
@RestController
@RequestMapping("/api/v1")
public class ModalidadeController {

    @Autowired
    IServiceModalidade modalidadeService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

}