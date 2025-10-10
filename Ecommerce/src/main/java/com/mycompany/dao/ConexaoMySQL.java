/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pedrolucas.melo
 */
public class ConexaoMySQL implements ConexaoDB{
    
   private static final String URL = "JDBC:MYSQL://LOCALHOST:3306/ecommerce";
   private static final String USUARIO = "root";
   private static final String SENHA = "catolica";
   
  @Override
  public Connection obterConexao() throws Exception {
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          
          Connection conexao = DriveManage.getConnection(URL, USUARIO, SENHA);
          System.out.println("Conexao com o banco de dados estabelecida com sucesso!");
          return conexao;
      } catch (classNotFoundException e) {
          throw new Exception("Driver JBDC do MySQL nao encontrado: " + e.getMessage());
      } catch (SQLException e) {
          throw new Exception("Erro ao conectar ao banco de dados: " + e.getMessage() );
      }
  
    
}
