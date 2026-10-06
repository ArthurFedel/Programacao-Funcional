package Show;

import java.util.*;

class Convidado {
    private String nome;
    private String email;
    private String empresa;

    public Convidado(String nome, String email, String empresa) {
        this.nome = nome; this.email = email; this.empresa = empresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Convidado convidado = (Convidado) o;
        return email.trim().toLowerCase().equals(convidado.email.trim().toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(email.trim().toLowerCase());
    }
}