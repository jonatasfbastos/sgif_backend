/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.funcaoterceirizado.service;

import br.com.ifba.funcaoterceirizado.model.FuncaoTerceirizado;
import java.util.List;

/**
 *
 * @author ph715
 */
public interface IServiceFuncaoTerceirizado {
    FuncaoTerceirizado saveFuncaoTerceirizado(FuncaoTerceirizado funcaoTerceirizado);
    String deleteFuncaoTerceirizado(Long id);
    List<FuncaoTerceirizado> getAllFuncoesTerceirizado();
}
