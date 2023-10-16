package br.com.ifba.infrastructure.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.function.Function;
import java.util.List;

/**
 * @author Giovane Neves
 * Desde V1.0.1
 *
 * Componente útil para conversão de uma classe para outra.
 */
@Component
public class ObjectMapperUtil {

    private static final ModelMapper MODEL_MAPPER;

    /**
     * Bloco de código estático para instanciar o ModelMapper
     */
    static{
        MODEL_MAPPER = new ModelMapper();
    }

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     *
     * Pega um objeto de entrada e converte-o para um objeto de saída.
     *
     * @param object O objeto que será convertido para Class<T>.
     * @param clazz O tipo de dado para o qual serão convertidos.
     * @return uma instância de clazz com os dados de object.
     * @param <Input> O tipo de entrada.
     * @param <Output> O tipo de saída.
     */
    public <Input, Output> Output map(final Input object, final Class<Output> clazz){

        return MODEL_MAPPER.map(object, clazz);

    }

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     *
     * Faz conversão de um objeto de um tipo para o outro no contexto funcional.
     *
     * @param clazz O tipo de para o qual o objeto será convertido.
     * @return ma instância de clazz com os dados do objeto de entrada.
     * @param <Input> O tipo de entrada.
     * @param <Output> O tipo de saída.
     */
    public <Input, Output> Function<Input, Output> mapFn(final Class<Output> clazz){

        return object -> MODEL_MAPPER.map(object, clazz);

    }

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     *
     * Converte uma lista de objetos de um tipo para uma lista de objetos Class<T>.
     *
     * @param objectList A lista de objetos a ser convertida.
     * @param clazz O tipo de dados para o qual serão convertidos.
     * @return uma lista de objectList convertida para o tipo clazz.
     * @param <Input> O tipo de entrada.
     * @param <Output> O tipo de saída.
     */
    public <Input, Output> List<Output> mapAll(final Collection<Input> objectList, final Class<Output> clazz){

        return objectList.stream()
                .map(object -> MODEL_MAPPER.map(object, clazz))
                .toList();
    }

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     *
     * @param clazz O tipo para o qual a lista será convertida.
     * @return uma lista de Class<T>.
     * @param <Input> O tipo de entrada.
     * @param <Output> O tipo de saída.
     */
    public <Input, Output> Function<List<Input>, List<Output>> mapAllFn(final Class<Output> clazz){

        return objectList -> objectList.stream()
                .map(object -> MODEL_MAPPER.map(object, clazz))
                .toList();
    }



}
