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
                System.out.println("1 - Listar produtos disponíveis");
                System.out.println("2 - Adicionar produto ao carrinho");
                System.out.println("3 - Visualizar carrinho");
                System.out.println("4 - Remover item do carrinho");
                System.out.println("5 - Finalizar pedido");
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
                            System.out.println("Não há produtos cadastrados no estoque.");
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
                   case 2 -> {
    System.out.println("=== ADICIONAR PRODUTO AO CARRINHO ===");

    // Lista os produtos disponíveis
    List<Produto> produtosDisponiveis = repositorio.listarTodos();
    if (produtosDisponiveis.isEmpty()) {
        System.out.println("Não há produtos disponíveis no momento.");
        System.out.println();
        break;
    }

    System.out.println("ID  |  NOME  |  PREÇO  |  ESTOQUE");
    System.out.println("-----------------------------------------");
    for (Produto p : produtosDisponiveis) {
        System.out.printf("%d | %s | R$ %.2f | %d\n",
            p.getId(),
            p.getNome(),
            p.getPreco(),
            p.getQuantidade_estoque()
        );
    }

    System.out.print("\nDigite o ID do produto que deseja adicionar ao carrinho: ");
    int idEscolhido = scanner.nextInt();

    Produto produtoSelecionado = null;
    for (Produto p : produtosDisponiveis) {
        if (p.getId() == idEscolhido) {
            produtoSelecionado = p;
            break;
        }
    }

    if (produtoSelecionado == null) {
        System.out.println("Produto não encontrado. Tente novamente.");
        System.out.println();
        break;
    }

    if (produtoSelecionado.getQuantidade_estoque() <= 0) {
        System.out.println("Produto sem estoque disponível.");
        System.out.println();
        break;
    }

    // Adiciona ao carrinho
    carrinhoCompras.add(produtoSelecionado);

    // Atualiza o estoque
    produtoSelecionado.setQuantidade_estoque(produtoSelecionado.getQuantidade_estoque() - 1);
    repositorio.salvar(produtoSelecionado);

    System.out.println("Produto \"" + produtoSelecionado.getNome() + "\" adicionado ao carrinho!");
    System.out.println();
}

                    case 3 -> { }
                    case 4 -> { }
                    case 5 -> { }
                    case 6 -> {
                        System.out.println("Encerrando o programa...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Opção indisponível! Tente novamente.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Erro, você digitou algo que é distinto a um número. Por favor, digite novamente.");
                scanner.nextLine();
            } catch (Exception e) {
                System.err.println("FALHA AO ACESSAR DADOS!");
                System.err.println("Informações do erro: " + e.getMessage());
            }
        }
    }
}
