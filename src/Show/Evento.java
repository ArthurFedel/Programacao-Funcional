package Show;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Evento {
    public static void main(String[] args) {
        List<Convidado> lista = Arrays.asList(
                new Convidado("Ana", "Ana@Empresa.com", "Empresa A"),
                new Convidado("Ana 2", "ana@empresa.com ", "Empresa A"),
                new Convidado("Bruno", "bruno@email.com", "Empresa B")
        );

        Set<Convidado> semDuplicatas = new HashSet<>(lista);
        System.out.println("Tamanho antes: " + lista.size() + " | Depois do Set: " + semDuplicatas.size());

        Set<Convidado> confirmados = new HashSet<>(Arrays.asList(new Convidado("Bruno C", "bruno@email.com", "Empresa B")));

        Set<Convidado> presentes = new HashSet<>(semDuplicatas);
        presentes.retainAll(confirmados); // Intersecção
        System.out.println("Confirmaram presença: " + presentes.size());

        Set<Convidado> ausentes = new HashSet<>(semDuplicatas);
        ausentes.removeAll(confirmados); // Diferença
        System.out.println("Ainda não confirmaram: " + ausentes.size());
    }
}
