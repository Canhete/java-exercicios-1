// Para se utilizar arrays dinâmicos, o java já tem um tipo para isso, o ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class SomaArray {
    public static ArrayList<Float> montarArray() {
        ArrayList<Float> arrayDinamico = new ArrayList<>();
        int i = 0;

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.printf("Digite o %d elemento do array: ", i + 1);

            float numero = input.nextFloat();
            arrayDinamico.add(numero);

            i++;

            imprimirArray(arrayDinamico);

            System.out.print("Deseja adicionar outro número? (s/n) >");

            char letra = input.next().charAt(0);

            if (letra == 'N' || letra == 'n') break;
            else if (letra == 'S' || letra == 's') continue;
            else System.out.println("Opção inválida!");
            34
        }

        input.close();

        return arrayDinamico;
    }

    public static void imprimirArray(ArrayList<Float> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.printf("[%d]: %.2f%n", i, array.get(i));
        }
    }

    public static float somarElementosArray(ArrayList<Float> array) {
        float acumulador = 0;

        for (int i = 0; i < array.size(); i++) {
            acumulador += array.get(i);
        }

        return acumulador;
    }

    public static void main(String[] arg) {
        ArrayList<Float> array = montarArray();

        imprimirArray(array);

        float soma = somarElementosArray(array);

        System.out.printf("Soma: %.2f%n", soma);
    }
}
