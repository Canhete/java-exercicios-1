import java.util.ArrayList;

// Como o item de linha depende da fatura para existir trata-se de uma composição
// itemDeLinha deve ser instanciado dentro da classe Fatura

public class Faturas {
    public static class Fatura {
        // Atributos
        private ArrayList<ItemDeLinha> itensDeLinha = new ArrayList<>();
        private Endereco endereco;

        // Constructor
        public Fatura(ArrayList<ItemDeLinha> itensDeLinha, Endereco endereco) {
            this.itensDeLinha = itensDeLinha;
            this.endereco = endereco;
        }

        // Metodos
        public void adiciona(Produto produto, int quantidade) {
            ItemDeLinha item(quantidade);
            itensDeLinha.add(produto);
        }

        public String formata() {

        }

        // Getters
        public ArrayList<ItemDeLinha> getItemDeLinha() { return this.itensDeLinha; }
        public Endereco getEndereco() { return this.endereco; }
    }

    public static class Endereco {
        // Atributos
        private String rua;
        private String cidade;

        // Constructor
        public Endereco(String rua, String cidade) {
            this.rua = rua;
            this.cidade = cidade;
        }

        // Getter
        public String getRua() { return this.rua; }
        public String getCidade() { return this.cidade; }
    }

    public static class ItemDeLinha {
        // Atributos
        private int quantidade;

        // Constructor
        public ItemDeLinha(int quantidade) {
            this.quantidade = quantidade;
        }

        // Getters
        public int getQuantidade() { return this.quantidade; }
        public double getCobrancaTotal(Produto p) {
            double valor = p.getPreco() * quantidade;
            return valor;
        }
    }

    public static class Produto {
        // Atributos
        private String descricao;
        private double preco;

        // Constructor
        public Produto(String descricao, double preco) {
            this.descricao = descricao;
            this.cidade = cidade;
        }

        // Getter
        public String getDescricao() { return this.descricao; }
        public double getPreco() { return this.preco; }


    }

    public static void main(String[] args) {
        Fatura fatura = new Fatura(
                new ArrayList<ItemDeLinha>(),
                new Endereco("Rua Amélia Figueredo", "São Paulo")
        );

        // Lista de produtos
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Videogame", 1400.00));
        produtos.add(new Produto("Televisão", 1800.00));
        produtos.add(new Produto("Caixa de som", 825.00));
        produtos.add(new Produto("Air Fryer", 750.00));
        produtos.add(new Produto("Roupa de cama", 100.00));

        fatura.getItemDeLinha().add(new ItemDeLinha("Videogame", 1400.00, 1));
        fatura.getItemDeLinha().add(new ItemDeLinha("Televisão", 1800.00, 1));
        fatura.getItemDeLinha().add(new ItemDeLinha("Caixa de som", 825.00, 1));
        fatura.getItemDeLinha().add(new ItemDeLinha("Air Fryer", 750.00, 2));
        fatura.getItemDeLinha().add(new ItemDeLinha("Roupa de cama", 100.00, 3));

        System.out.println("================================================");
        System.out.printf("Endereco: %-20s %-10 %n", fatura.getEndereco().getRua(), fatura.getEndereco().getCidade());
        System.out.println("==================== Fatura ====================");

        for (int i = 0; i < fatura.getItemDeLinha().size(); i++) {
            System.out.printf("%-15s %-10.2f %-10d %-10.2f %n",
                    fatura.getItemDeLinha().get(i).getNome(),
                    fatura.getItemDeLinha().get(i).getPreco(),
                    fatura.getItemDeLinha().get(i).getQuantidade(),
                    fatura.getItemDeLinha().get(i).getCobrancaTotal()
            );
        }

        System.out.println("===================== Total ====================");
        System.out.printf("%45.2f", fatura.getCustoTotal());
    }
}