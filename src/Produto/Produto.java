package Produto;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// 1. Definição da classe Produto (Modelo de dados)
class Produto {
    private String nome;
    private String categoria;
    private double preco;
    private double avaliacao;
    private boolean emEstoque;

    public Produto(String nome, String categoria, double preco, double avaliacao, boolean emEstoque) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.avaliacao = avaliacao;
        this.emEstoque = emEstoque;
    }

    // Getters necessários para as Lambdas e Method References
    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public double getPreco() { return preco; }
    public double getAvaliacao() { return avaliacao; }
    public boolean isEmEstoque() { return emEstoque; }

    // Cálculo do preço final com regra de negócio (desconto por categoria)
    public double getPrecoFinal() {
        if ("Eletrônicos".equalsIgnoreCase(categoria)) {
            return preco * 0.85; // 15% de desconto
        }
        return preco * 0.90;     // 10% de desconto nas demais
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - R$ %.2f [Nota: %.1f]",
                nome.toUpperCase(), categoria, getPrecoFinal(), avaliacao);
    }
}