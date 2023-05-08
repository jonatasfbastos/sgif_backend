package br.com.ifba.matrizcurricular.service;

import java.util.List;

import br.com.ifba.matrizcurricular.model.MatrizCurricular;

public interface IServiceMatrizCurricular {

    public MatrizCurricular saveMatrizCurricular(MatrizCurricular matrizCurricular);
    public MatrizCurricular updateMatrizCurricular(MatrizCurricular matrizCurricular);
    public void deleteMatrizCurricular(Long id);
    public List<MatrizCurricular> getAllMatrizCurricular();
    public List<MatrizCurricular> findByNome(String nome);
    public MatrizCurricular findById(Long id);
    
}
