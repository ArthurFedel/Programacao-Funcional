package Produto;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SistemaProdutos {

    public static void main(String[] args) {
        // Base de dados para teste
        List<Produto> produtos = Arrays.asList(
                new Produto("Notebook Gamer", "Eletrônicos", 5000.0, 4.8, true),
                new Produto("Smartphone", "Eletrônicos", 2500.0, 4.2, true),
                new Produto("Mouse Simples", "Eletrônicos", 50.0, 3.5, true),     // Reprovado na avaliação
                new Produto("Cadeira Ergonomica", "Móveis", 1200.0, 4.5, true),
                new Produto("Mesa para Escritório", "Móveis", 800.0, 4.1, false), // Fora de estoque
                new Produto("Monitor 4K", "Eletrônicos", 3000.0, 4.9, true),
                new Produto("Livro Java Avançado", "Livros", 150.0, 4.7, true)
        );

        System.out.println("=== 1. FILTRAGEM E EXIBIÇÃO SIMPLES ===");

        // Predicate reutilizável (Filtro)
        Predicate<Produto> aptosParaRelatorio = p -> p.isEmEstoque() && p.getAvaliacao() >= 4.0;

        produtos.stream()
                .filter(aptosParaRelatorio)
                .sorted(Comparator.comparing(Produto::getPrecoFinal).reversed()) // Ordenação decrescente por preço final
                .forEach(System.out::println); // Method reference em vez de p -> System.out.println(p)

        System.out.println("\n=== 2. AGRUPAMENTO COM ESTATÍSTICAS (groupingBy) ===");

        // Agrupa por categoria e calcula estatísticas do preço final de cada categoria
        Map<String, DoubleSummaryStatistics> estatisticasPorCategoria = produtos.stream()
                .filter(aptosParaRelatorio)
                .collect(Collectors.groupingBy(
                        Produto::getCategoria,
                        Collectors.summarizingDouble(Produto::getPrecoFinal)
                ));

        estatisticasPorCategoria.forEach((categoria, stats) -> {
            System.out.println("Categoria: " + categoria);
            System.out.println("  - Quantidade de Itens: " + stats.getCount());
            System.out.printf("  - Média de Preço: R$ %.2f\n", stats.getAverage());
            System.out.printf("  - Preço Mínimo: R$ %.2f\n", stats.getMin());
            System.out.printf("  - Preço Máximo: R$ %.2f\n", stats.getMax());
            System.out.printf("  - Soma Total: R$ %.2f\n", stats.getSum());
        });

        System.out.println("\n=== 3. TOP 3 PRODUTOS MAIS CAROS (limit + collect) ===");

        List<String> top3Nomes = produtos.stream()
                .filter(aptosParaRelatorio)
                .sorted(Comparator.comparing(Produto::getPrecoFinal).reversed())
                .limit(3) // Pega apenas os 3 primeiros do fluxo
                .map(p -> p.getNome().toUpperCase()) // Transforma Produto -> String
                .collect(Collectors.toList());

        System.out.println("Top 3 Produtos: " + top3Nomes);
    }
}