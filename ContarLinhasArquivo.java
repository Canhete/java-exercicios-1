import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContarLinhasArquivo {
    public static int contarLinhas(String nome) {
        int linhas = 0;

        try {
            File arq = new File(nome);
            Scanner scanner = new Scanner(arq);

            while (scanner.hasNextLine()) {
                scanner.nextLine();
                linhas++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }

        return linhas;
    }

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo (com a extensão): ");

        String nome = input.nextLine();

        input.close();

        int linhas = contarLinhas(nome);

        System.out.printf("O arquivo '%s' tem %d linhas.%n", nome, linhas);
    }
}
