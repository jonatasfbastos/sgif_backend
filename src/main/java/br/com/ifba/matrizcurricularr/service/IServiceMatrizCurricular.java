package br.com.ifba.matrizcurricularr.service;

import java.util.List;

import br.com.ifba.matrizcurricularr.model.MatrizCurricular;

public interface IServiceMatrizCurricular {

    public MatrizCurricular saveMatrizCurricular(MatrizCurricular matrizCurricular);
    public MatrizCurricular updateMatrizCurricular(MatrizCurricular matrizCurricular);
    public void deleteMatrizCurricular(MatrizCurricular matrizCurricular);
    public List<MatrizCurricular> getAllMatrizCurricular();
    public List<MatrizCurricular> findByNome(String nome);
    public MatrizCurricular findById(Long id);
    
}
