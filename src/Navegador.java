import java.util.ArrayDeque;
import java.util.Deque;

public class Navegador {
    private String paginaAtual;
    private Deque<String> historicoVoltar = new ArrayDeque<>();
    private Deque<String> historicoAvancar = new ArrayDeque<>();

    public void visitar(String url) {
        if (paginaAtual != null) {
            historicoVoltar.push(paginaAtual);
        }
        paginaAtual = url;
        historicoAvancar.clear();
    }

    public boolean voltar() {
        if (historicoVoltar.isEmpty()) return false;
        historicoAvancar.push(paginaAtual);
        paginaAtual = historicoVoltar.pop();
        return true;
    }

    public boolean avancar() {
        if (historicoAvancar.isEmpty()) return false;
        historicoVoltar.push(paginaAtual);
        paginaAtual = historicoAvancar.pop();
        return true;
    }

    public void exibirStatus() {
        System.out.println("Atual: " + paginaAtual + " | Voltar: " + historicoVoltar.size() + " | Avançar: " + historicoAvancar.size());
    }

    public static void main(String[] args) {
        Navegador nav = new Navegador();
        nav.visitar("A"); nav.visitar("B"); nav.visitar("C");
        nav.exibirStatus();
        nav.voltar(); nav.voltar(); nav.exibirStatus();
        nav.avancar(); nav.exibirStatus();
        nav.visitar("D"); nav.exibirStatus();
        nav.voltar(); nav.exibirStatus();
        nav.avancar(); nav.avancar(); nav.exibirStatus(); // Avançar pela segunda vez deve falhar (retornará false no método e não fará nada extra)

        System.out.println("Histórico Voltar:");
        nav.historicoVoltar.forEach(System.out::println);
    }
}