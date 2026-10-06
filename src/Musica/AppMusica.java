package Musica;

import Musica.Faixa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AppMusica {
    public static void main(String[] args) {
        List<Faixa> playlist = new ArrayList<>(Arrays.asList(
                new Faixa("M1", "Art1", 180, 2020, 5),
                new Faixa("M2", "Art2", 200, 2021, 2),
                new Faixa("M3", "Art1", 190, 2019, 10),
                new Faixa("M4", "Art3", 210, 2020, 1),
                new Faixa("M5", "Art4", 150, 2022, 50)
        ));

        // b) Ordenar por artista e depois por ano decrescente
        playlist.stream()
                .sorted(Comparator.comparing(Faixa::getArtista).thenComparing(Faixa::getAno, Comparator.reverseOrder()))
                .forEach(f -> System.out.println(f.artista + " - " + f.titulo + " (" + f.ano + ")"));

        // c) Top 5 mais reproduzidas
        playlist.stream()
                .sorted(Comparator.comparing(Faixa::getReproducoes).reversed())
                .limit(5)
                .forEach(f -> System.out.println(f.titulo + ": " + f.reproducoes));

        // d) Remover faixas com menos de 3 reproduções
        int tamanhoAntes = playlist.size();
        playlist.removeIf(f -> f.reproducoes < 3);
        System.out.println("Removidas: " + (tamanhoAntes - playlist.size()));

        // e) Duração total no formato hh:mm:ss
        int totalSegundos = playlist.stream().mapToInt(f -> f.duracaoSegundos).sum();
        System.out.printf("Duração total: %02d:%02d:%02d\n", totalSegundos / 3600, (totalSegundos % 3600) / 60, totalSegundos % 60);
    }
}