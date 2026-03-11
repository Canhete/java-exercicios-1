import java.util.ArrayList;

public class FiltrarPalavras {
    public static int filtrarPalavras(ArrayList<String> palavras) {
        int removido = 0;

        for (int i = palavras.size() - 1; i >= 0; i--) {
            if (palavras.get(i).length() < 4) {
                palavras.remove(i);
                removido += 1;
            }
        }

        return removido;
    }

    public static void main(String[] args) {
        ArrayList<String> palavras = new ArrayList<>();
        palavras.add("Biscoito");
        palavras.add("Bochecha");
        palavras.add("Bola");
        palavras.add("Batata");
        palavras.add("Bisnaga");
        palavras.add("Brinquedo");
        palavras.add("Boneca");
        palavras.add("Bia");
        palavras.add("Bob");
        palavras.add("Branco");

        for (int i = 0; i < palavras.size(); i++) {
            System.out.println("[" + i + "] " + palavras.get(i));
        }
        System.out.printf("=== %d palavras no total ===%n", palavras.size());

        int removido = filtrarPalavras(palavras);

        for (int i = 0; i < palavras.size(); i++) {
            System.out.println("[" + i + "] " + palavras.get(i));
        }

        System.out.printf("=== %d palavras no total ===%n", palavras.size());
        System.out.printf("%5d palavra(s) removida(s) %n", removido);
    }
}