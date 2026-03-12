import java.util.ArrayList;
import java.util.List;

public class AMaquinaDeVenda {
    public class MaquinaDeVenda {
        private List<Produto> estoque;
        private List<Moeda> pagamentos;

        public MaquinaDeVenda() {
            estoque = new ArrayList<>();
            pagamentos = new ArrayList<>();
        }

        public void compra(Produto p, ArrayList<Moeda> m) {
            if (p.equals(m))
        }

        public List<Produto> getEstoque() {
            return estoque;
        }
        public List<Moeda> getPagamentos() {
            return pagamentos;
        }
    }

    public static class Produto {
        private String nome;
        private double preco;
        private int quantidade;

        public Produto(String nome, double preco, int quantidade) {
            this.nome = nome;
            this.preco = preco;
            this.quantidade = quantidade;
        }
        
        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        public String getNome() {
            return nome;
        }
        public double getPreco() {
            return preco;
        }
        public int getQuantidade() {
            return quantidade;
        }
    }

    public static class Moeda {
        private double valor;
        private int quantidade;

        public Moeda(double valor, int quantidade) {
            this.valor = valor;
            this.quantidade = quantidade;
        }

        public double calcular() {
            return valor * quantidade;
        }

        public int getQuantidade() {
            return quantidade;
        }
        public double getValor() {
            return valor;
        }
    }

    public static void main(String[] args) {
        MaquinaDeVenda m = new MaquinaDeVenda();
        
        m.add(List.of(
            new Produto("Barra de Cereal", 10.00, 30);
        ))
    }
}
