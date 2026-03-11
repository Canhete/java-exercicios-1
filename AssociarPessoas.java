import java.util.ArrayList;

public class AssociarPessoas {
    public static class Pessoa {
        // Atributos
        private String nome;
        private ArrayList<Pessoa> amigos = new ArrayList<>();

        // Constructor
        public Pessoa(String nome) {
            this.nome = nome;
        }

        public void fazerAmizade(Pessoa p) {
            if (p == null || p == this) {
                return;
            }

            // Verifica se já sao amigos
            if (this.amigos.contains(p)) {
                System.out.println(this.nome + " e " + p.getNome() + " já são amigos!");
                return;
            }

            // Ambos precisam se tornar amigos um do outro
            this.amigos.add(p);
            p.amigos.add(this);

            System.out.println(this.nome + " e " + p.getNome() + " agora são amigos!");
        }

        // Getters
        public void getNomesAmigos() {
            System.out.println("Amigos de " + this.nome);

            for (Pessoa amigo : this.amigos) {
                System.out.println(amigo.getNome());
            }
        }

        public String getNome() { return this.nome; }
    }

    public static void main(String[] args) {
        Pessoa p = new Pessoa("Pedro");
        Pessoa a = new Pessoa("Ana");
        Pessoa b = new Pessoa("Beto");
        Pessoa c = new Pessoa("Carlos");
        Pessoa d = new Pessoa("Dante");

        p.fazerAmizade(a);
        b.fazerAmizade(a);
        c.fazerAmizade(b);
        a.fazerAmizade(b);
        d.fazerAmizade(d);
        d.fazerAmizade(a);
        d.fazerAmizade(b);
        d.fazerAmizade(c);

        p.getNomesAmigos();
        a.getNomesAmigos();
        b.getNomesAmigos();
        c.getNomesAmigos();
        d.getNomesAmigos();
    }
}
