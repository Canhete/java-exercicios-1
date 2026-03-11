import java.util.Scanner;
import java.util.ArrayList;

public class MaiorValorArray {
    public static ArrayList<Float> montarArray() {
        ArrayList<Float> arrayDinamico = new ArrayList<Float>();
        Scanner input = new Scanner(System.in);
        int i = 0;

        while (true) {
            System.out.printf("Digite o %d elemento do array: ", i+1);

            float numero = input.nextFloat();
            arrayDinamico.add(numero);
            i++;

            System.out.printf("Deseja adicionar mais números ao array? (s/n) >");

            char letra = input.next().charAt(0);

            if (letra == 'N' || letra == 'n') break;
            else if (letra == 'S' || letra == 's') continue;
            else System.out.println("Opção inválida!");
        }

        input.close();

        return arrayDinamico;
    }

    public static void imprimirArray(ArrayList<Float> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.printf("[%d]: %.2f%n", i, array.get(i));
        }
    }

    public static Resultado maiorValorArray(ArrayList<Float> array) {
        float maior = array.get(0);
        int index = 0;

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > maior) {
                maior = array.get(i);
                index = i;
            }
        }

        return new Resultado(index, maior);
    }

    public static class Resultado {
        int index;
        float valor;

        Resultado(int index, float valor) {
            this.index = index;
            this.valor = valor;
        }
    }

    public static void main(String[] arg) {
        ArrayList<Float> array = montarArray();

        Resultado res = maiorValorArray(array);

        imprimirArray(array);

        System.out.printf("Maior elemento -> [%d]: %.2f", res.index, res.valor);
    }
}
