import java.util.Scanner;

public class AlgoritmosArrays {
    public static double maiorValor(double[] array) {
        double maior = array[0];

        for (double a : array) {
            if (a > maior) {
                maior = a;
            }
        }

        return maior;
    }

    public static double menorValor(double[] array) {
        double menor = array[array.length - 1];

        for (double a : array) {
            if (a < menor) {
                menor = a;
            }
        }

        return menor;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] array = new double[10];

        for (int i = 0; i < 10; i++) {
            System.out.printf("Digite o %d numero real: ", i+1);

            array[i] = input.nextDouble();
        }

        double maior = maiorValor(array);
        double menor = menorValor(array);

        System.out.printf("Maior valor: %.2f%n", maior);
        System.out.printf("Menor valor: %.2f%n", menor);
    }
}
