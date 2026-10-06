package AberturaConta;

import java.util.function.Predicate;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class Cadastro {
    String nome, email, senha;
    int idade;
    public Cadastro(String n, String e, String s, int i) { nome=n; email=e; senha=s; idade=i; }
}