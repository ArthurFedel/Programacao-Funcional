package AberturaConta;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Validador {
    public static void main(String[] args) {
        // a) Predicates
        Predicate<Cadastro> nomeValido = c -> c.nome.length() >= 3;
        Predicate<Cadastro> emailValido = c -> c.email.contains("@") && c.email.contains(".");
        Predicate<Cadastro> senhaTamanho = c -> c.senha.length() >= 8;
        Predicate<Cadastro> senhaDigito = c -> c.senha.matches(".*\\d.*");
        Predicate<Cadastro> idadeValida = c -> c.idade >= 18 && c.idade <= 120;

        // b) Combinando
        Predicate<Cadastro> cadastroValido = nomeValido.and(emailValido).and(senhaTamanho).and(senhaDigito).and(idadeValida);
        Predicate<Cadastro> senhaFraca = senhaTamanho.negate().or(senhaDigito.negate());

        // c) Lista de Regras (para retornar mensagens)
        List<Regra> regras = Arrays.asList(
                c -> c.nome.length() >= 3 ? null : "Nome curto",
                c -> (c.email.contains("@") && c.email.contains(".")) ? null : "E-mail inválido",
                c -> c.senha.length() >= 8 ? null : "Senha curta"
        );
    }

    public static List<String> erros(Cadastro c, List<Regra> regras) {
        return regras.stream()
                .map(r -> r.validar(c))
                .filter(erro -> erro != null) // mantem apenas as falhas
                .collect(Collectors.toList());
    }
}