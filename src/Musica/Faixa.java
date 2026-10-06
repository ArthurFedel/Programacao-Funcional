package Musica;

import java.util.*;

public class Faixa {
    String titulo, artista;
    int duracaoSegundos, ano, reproducoes;

    public Faixa(String t, String a, int d, int ano, int r) {
        this.titulo = t; this.artista = a; this.duracaoSegundos = d; this.ano = ano; this.reproducoes = r;
    }
    public String getArtista() { return artista; }
    public int getAno() { return ano; }
    public int getReproducoes() { return reproducoes; }
    public String getTitulo() { return titulo; }
}
