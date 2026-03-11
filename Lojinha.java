import java.util.ArrayList;

public class Lojinha {
    public static class Loja {
        private ArrayList<Cliente> clientes = new ArrayList<>();

        // Constructor
        public Loja(ArrayList<Cliente> clientes) {
            this.clientes = clientes;
        }

        // Getter
        public Cliente getMelhorCliente() {
            if (clientes.isEmpty()) {
                throw new IllegalStateException("Lista de clientes vazia");
            }

            Cliente melhor = clientes.get(0);

            for (int i = 1; i < clientes.size(); i++) {
                if (clientes.get(i).getValorGasto() > melhor.getValorGasto()) {
                    melhor = clientes.get(i);
                }
            }

            return melhor;
        }
    }

    public static class Cliente {
        private String nome;
        private double valorGasto;

        // Constructor
        public Cliente(String nome, double valorGasto) {
            this.nome = nome;
            this.valorGasto = valorGasto;
        }

        // Getters
        public String getNome() { return this.nome; }
        public double getValorGasto() { return this.valorGasto; }
    }

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Ana", 130.00));
        clientes.add(new Cliente("Beto", 20.00));
        clientes.add(new Cliente("Carlos", 30.00));
        clientes.add(new Cliente("Dante", 60.50));
        clientes.add(new Cliente("Eduardo", 75.25));
        clientes.add(new Cliente("Fernandez", 21.00));
        clientes.add(new Cliente("Gabriel", 120.00));
        clientes.add(new Cliente("Herald", 30.00));
        clientes.add(new Cliente("Inês", 10.00));
        clientes.add(new Cliente("Janira", 78.89));

        Loja cafeteria = new Loja(clientes);

        Cliente melhorCliente = cafeteria.getMelhorCliente();

        System.out.println("Cliente que mais gastou: " + melhorCliente.getNome() + ", R$ " + melhorCliente.getValorGasto());
    }
}