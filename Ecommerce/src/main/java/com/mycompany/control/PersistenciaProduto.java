package com.mycompany.control;

import com.mycompany.model.Produto;
import com.mycompany.dao.ConexaoDB; 
import com.mycompany.dao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaProduto implements RepositorioDeProdutos {

    private final ConexaoDB conexaoDB = new ConexaoMySQL(); 
    
    private static final String TABELA = "produtos"; 
    private static final String COL_ID = "id"; 
    private static final String COL_NOME = "nome"; 
    private static final String COL_DESCRICAO = "descricao"; 
    private static final String COL_PRECO = "preco"; 
    private static final String COL_QTD_ESTOQUE = "quantidade_estoque"; 

    @Override
    public List<Produto> listarTodos() throws Exception {
        List<Produto> listaProdutos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet resultado = null;

        try {
            conexao = conexaoDB.obterConexao();
            String sql = "SELECT * FROM " + TABELA;
            stmt = conexao.prepareStatement(sql);
            resultado = stmt.executeQuery();

            while (resultado.next()) {
                Produto p = new Produto(
                    resultado.getInt(COL_ID),
                    resultado.getString(COL_NOME),
                    resultado.getString(COL_DESCRICAO),
                    resultado.getDouble(COL_PRECO),
                    resultado.getInt(COL_QTD_ESTOQUE)
                );
                listaProdutos.add(p);
            }
        } catch (SQLException e) {
            throw new Exception("Falha ao listar produtos: " + e.getMessage(), e);
        } finally {
            conexaoDB.fecharConexao(conexao); 
        }

        return listaProdutos;
    }

    @Override
    public void salvar(Produto produto) throws Exception {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = conexaoDB.obterConexao();
            String sql = "UPDATE " + TABELA + " SET "
                       + COL_NOME + " = ?, "
                       + COL_DESCRICAO + " = ?, "
                       + COL_PRECO + " = ?, "
                       + COL_QTD_ESTOQUE + " = ? "
                       + "WHERE " + COL_ID + " = ?";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidade_estoque());
            stmt.setInt(5, produto.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Falha ao atualizar produto: " + e.getMessage(), e);
        } finally {
            if (stmt != null) stmt.close();
            conexaoDB.fecharConexao(conexao);
        }
    }
}
