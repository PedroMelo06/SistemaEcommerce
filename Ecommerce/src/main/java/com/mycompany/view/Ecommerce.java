/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.view;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.mycompany.model.Produto;
import com.mycompany.control.PersistenciaProduto;
import com.mycompany.control.RepositorioDeProdutos;
/**
 *
 * @author pedrolucas.melo
 */
public class Ecommerce {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        
        RepositorioDeProdutos repositorio = new PersistenciaProduto();
        Scanner scanner = new Scanner(System.in);
        List<Produto> carrinhoCompras = new ArrayList<>();

        while (true) {
            try {
                System.out.println("=== SISTEMA DE E-COMMERCE ===");
                System.out.println("1 - Listar produtos");
                System.out.println("2 - Adicionar ao carrinho");
                System.out.println("3 - Ver carrinho");
                System.out.println("4 - Remover do carrinho");
                System.out.println("5 - Finalizar compra");
                System.out.println("6 - Sair");
                System.out.print("Escolha a opcao: ");
                
                int escolha = scanner.nextInt();
                scanner.nextLine();

                System.out.println();
                
                switch (escolha) {
                    case 1 -> {
                        System.out.println("=== LISTA DE PRODUTOS DISPONÍVEIS ===");
                        List<Produto> produtosAtuais = repositorio.listarTodos();
                        System.out.println("ID  |  NOME  |  PREÇO  |  ESTOQUE");
                        System.out.println("-----------------------------------------");
                        
                        if (produtosAtuais.isEmpty()) {
                            System.out.println("Nenhum produto encontrado no estoque.");
                        } else {
                            for (Produto item : produtosAtuais) {
                                System.out.printf("%d | %s | R$ %.2f | %d\n",
                                    item.getId(),
                                    item.getNome(),
                                    item.getPreco(),
                                    item.getQuantidade_estoque()
                                );
                            }
                            System.out.println();
                        }
                    }
                    case 2 -> { }
                    case 3 -> { }
                    case 4 -> { }
                    case 5 -> { }
                    case 6 -> {
                        System.out.println("Finalizando o sistema...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Erro, você digitou algo que não é um número. Por favor, digite novamente.");
                scanner.nextLine();
            } catch (Exception e) {
                System.err.println("ERRO NO ACESSO A DADOS!");
                System.err.println("Detalhes: " + e.getMessage());
            }
        }
    }
}