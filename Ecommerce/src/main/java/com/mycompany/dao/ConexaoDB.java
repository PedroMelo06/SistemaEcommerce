/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import java.sql.Connection;

/**
 *
 * @author pedrolucas.melo
 */
public interface ConexaoDB {
    
    Connection obterConexao() throws Exception;
    
    void fecharConexao(Connection conexao);
   
}
