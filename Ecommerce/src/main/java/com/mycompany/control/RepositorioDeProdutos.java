/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.control;

import com.mycompany.model.Produto;
import java.util.List;
/**
 *
 * @author pedrolucas.melo
 */
public interface RepositorioDeProdutos {
    
    List<Produto> listarTodos() throws Exception;
    
    void salvar(Produto produto) throws Exception; // <-- novo método
}
    
