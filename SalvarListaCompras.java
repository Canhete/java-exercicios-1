import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class SalvarListaCompras {
    // O array de compras existe por fora
    ArrayList<Compra> compras = new ArrayList<>();

    // Classe de compra
    public static class Compra {
        String nome;
        double valor;
        int quantidade;
        double subtotal;

        // Constructor
        Compra(String nome, double valor, int quantidade, double subtotal) {
            this.nome = nome;
            this.valor = valor;
            this.quantidade = quantidade;
            this.subtotal = subtotal;
        }
    }

    public void adicionarItem() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Nome do produto: ");
            String nome = input.nextLine();

            System.out.print("Preço (em R$): ");
            double valor = input.nextDouble();
            input.nextLine(); // Retira o enter após digitar o número

            System.out.print("Quantidade: ");
            int quantidade = input.nextInt();
            input.nextLine();

            double subtotal = valor * quantidade;

            compras.add(new Compra(nome, valor, quantidade, subtotal));

            System.out.print("Deseja adicionar outro produto? (s/n) >");
            char letra = input.next().charAt(0);
            input.nextLine();

            if (letra == 'N' || letra == 'n') break;
        }
    }

    public void gravarArquivo(String nome) {
        try {
            FileWriter escritor = new FileWriter(nome + ".csv");

            escritor.write("Nome;Valor;Quantidade;Subtotal\n");

            for (Compra c : compras) {
                escritor.write(c.nome + ";" + c.valor + ";" + c.quantidade + ";" + c.subtotal +"\n");
            }

            escritor.close();

            System.out.printf("Arquivo '%s.csv' salvo com sucesso!%n", nome);
        } catch (Exception e) {
            System.out.println("Erro ao gravar arquivo!");
        }
    }

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo a ser salvo (sem extensões): ");

        String nome = input.nextLine();

        SalvarListaCompras app = new SalvarListaCompras();

        app.adicionarItem();
        app.gravarArquivo(nome);

        input.close();
    }
}
