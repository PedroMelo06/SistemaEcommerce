/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author pedrolucas.melo
 */
public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade_estoque;

    public Produto() {
        quantidade_estoque = 0;
    }

    public Produto(String nome) {
        this();
        this.nome = nome;
    }

    public Produto(String nome, String descricao) {
        this(nome);
        this.descricao = descricao;
    }

    public Produto(String nome, String descricao, double preco) {
        this(nome, descricao);
        this.preco = preco;
    }

    public Produto(int id, String nome, String descricao, double preco, int quantidade_estoque) {
        this(nome, descricao, preco);
        this.id = id;
        this.quantidade_estoque = quantidade_estoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }
}
